<<<<<<< HEAD
#define _GNU_SOURCE#include <stdio.h>#include <stdlib.h>#include <string.h> //para o output#include "queue2.h"//#include "queue2.h"//Variáveis Globais Configuraveis#define MEMSIZE 400 // Tamnho do array#define Quantum 4  //Tamanho do Quantum#define max_ready 4 //Maximo de processos no ready#define nProcesses 8  //Numero de processosQueue *NEW;Queue *READY;Queue *RUN;Queue *BLOCKED;Queue *EXIT;int MEM[MEMSIZE];char buffer[100];int program_number;char *tempobuffer[nProcesses];PCB *pcbArray[nProcesses];int ins_array[nProcesses];//array de instantesint ciclo_temp = 0;//ciclo_temp atualint mem_processes = 0;//nr de processos em memóriaint fit_algorthim = 0;/*Funcoes do programa */void le_ficheiro(char* file) {    FILE* ficheiro;    char* linha = NULL;	size_t len = 0;	ssize_t read;	ficheiro = fopen(file, "r");	if(ficheiro == NULL){		printf("\nFicheiro não encontrado!\n");	}	else{		int i = 0;		while((read = getline(&linha, &len, ficheiro)) != -1){  //coloca o file todo no tempobuffer			tempobuffer[i] = strdup(linha);			i++;		}	}	fclose(ficheiro);}PCB* read_process(int n){    int counter = 0;    int counter2 = 0;//posição da memória para escrever    char *temp[5];//char temporario para guardar o ciclo_temp        //guarda ciclo_temp    while( tempobuffer[n][counter] != ' ')    {        temp[counter]=&tempobuffer[n][counter];        counter++;    }    if(n==0)//primeiro processo    {        ins_array[0] = atoi(*temp);        ciclo_temp = atoi(*temp);    }    else{ ins_array[n] = /*ins_array[n]+*/atoi(*temp);}    counter=counter+2;    //vai até á memória nao utilizada    while( MEM[counter2] != -1)    {        counter2++;    }    //cria PCB    PCB *p = new_pcb(n);    p -> inicio = counter2;//guarda o endereço do inicio das variáveis e instruções    //p->ciclo_temp=ins_array[n];//guarda o ciclo_temp no PCB    pcbArray[n]=p;	//espaços para variaveis na memoria	for(int i = 0; i < 10; i++)	{		MEM[counter2+i] =- 100;	}	counter2 = counter2 + 10;    while(true)    {    	if(tempobuffer[n][counter] == '\0')    	{    		break;    	}    	char *ins[2];//instrução    	ins[0] = &tempobuffer[n][counter-1];    	ins[1] = &tempobuffer[n][counter];    	MEM[counter2] = atoi(*ins);    	counter2++;    	counter = counter+3;    }    mem_processes++;	return p;}/*int best_fit(int tamanho) //devolve o indice onde deve ser colocado no MEM mas a "partir do fim" {    int i = 0; ;    //contador para percorrer o array MEM    int j = 0;      //contador para contar os espaços vazios seguidos    int menor = 50; //guardar o menor numero de espaços seguidos onde cabe as instruçoes     int indice = 0;     //guarda o indice         while(i<MEMSIZE)    {        if(MEM[i] == 'x')        {            j++;        }        else        {            if( j <= menor)            {   //verifica se o numero de espaços vazios seguidos é menor que o anteriormente guardado                if (j >= tamanho)                {   // verifica se este contem espaço para as instruções                    menor = j;                    indice = (i - tamanho);                }            }            j = 0;        }        i++;    }    if( i - j < menor)    {        indice = i - j;    }    return indice;}int worst_fit(int tamanho){    int i = 0; ;    //contador para percorrer o array MEM    int j = 0;      //contador para contar os espaços vazios seguidos    int maior = 0; //guardar o maior numero de espaços seguidos onde cabe as instruçoes     int indice = 0;     //guarda o indice         while(i<MEMSIZE)    {        if(MEM[i] == 'x')        {            j++;        }        else        {            if( j >= maior)            {   //verifica se o numero de espaços vazios seguidos é menor que o anteriormente guardado                if (j >= tamanho)                {   // verifica se este contem espaço para as instruções                    maior = j;                    indice = (i - tamanho);                }            }            j = 0;        }        i++;    }    if( i - j > maior)    {        indice = i - j;    }    return indice;}int next_fit(){}*/void print_MEM(){	for(int i=0;i<MEMSIZE;i++)	{		printf("%d ",MEM[i]);	}	printf("\n");}void ini_mem(){    for(int i=0;i<MEMSIZE;i++)    {        MEM[i]=-1;    }}//GO TO NEWvoid go_to_new(PCB *process){        Node *n = new_node(process);        enqueue(NEW,n);}//NEW----->READYvoid admit(){    if( NEW -> head != NULL){        if( (READY -> sizeQueue) < max_ready){            Node *pointer = dequeue(NEW);            enqueue(READY,pointer);        }    }}//READY----->runningvoid dispatch(){    if( READY -> head != NULL/*&&RUN->head==NULL*/)    {	        Node *pointer = dequeue(READY);        enqueue(RUN,pointer);    }}//RUNning---->EXITvoid release(){	Node *pointer = dequeue(RUN);    enqueue(EXIT,pointer);}//RUNning----->BLOCKEDvoid event_wait(){    Node *pointer = dequeue(RUN);    enqueue(BLOCKED, pointer);}void go_to_READY(Node *pointer){//Simplificar funcionamento do programa criando função para atividade repetida    if((READY -> sizeQueue) < max_ready)    {        enqueue(READY, pointer);    }}void timeout(){    go_to_READY(dequeue(RUN));}void event_occurs(){	if((READY -> sizeQueue) < (READY -> limit) && (BLOCKED -> sizeQueue) != 0)	{		    	go_to_READY(dequeue(BLOCKED));    }}//função que vai lidar com os processos no estado runningvoid running(PCB *asd,int roundrobin){		int number=MEM[(RUN->head->element->Pc) + 10+ (RUN->head->element->inicio)] ;	int value=(number -(number%10))/10;//nr da instrução	int var=number%10;//direita	printf("instrução--%d/%d\n",value,var);	printf("ID:%d\n",asd->id);	printf("posição:%d+%d\n",(asd->inicio),(asd->Pc));	if(value==0)	{		make_zero(var,asd);		roundrobin++;	}	if(value==1)	{		add(var,asd);		roundrobin++;	}	if(value==2)	{		subtract(var,asd);		roundrobin++;	}	if(value==3)	{		if_check(var,asd);		roundrobin++;	}	if(value==4)	{		back(var,asd);		roundrobin++;	}	if(value==5)	{		forward(var,asd);		roundrobin++;	}	if(value==7)	{		disk_save(asd);		roundrobin++;	}	if(value==8)	{		copy(var,asd);		roundrobin++;	}	if(value==9)	{		Exit(asd);		roundrobin++;	}	//print_MEM();}//função que vai lidar com os processos no estado blockedvoid make_zero(int variable,PCB *asd){    MEM[variable + asd->inicio]=0;    ciclo_temp++;    asd->Pc=asd->Pc+1;}void add(int variable,PCB *asd){    MEM[asd->inicio + variable]=MEM[asd->inicio+variable]+ 1;    ciclo_temp++;    asd->Pc=asd->Pc+1;}void subtract(int variable,PCB *asd){    MEM[asd->inicio + variable]=MEM[asd->inicio +variable]-1;    ciclo_temp++;    asd->Pc=asd->Pc+1;}void if_check(int variable,PCB *asd){    if( variable == 0){        asd->Pc++;    }    else{        asd->Pc += 2;    }    ciclo_temp++;}void back(int variable, PCB *asd){    int Pc=asd->Pc;        Pc -= variable;    ciclo_temp++;    asd->Pc=asd->Pc+1;}void forward(int variable, PCB *asd){    int Pc = asd -> Pc;    Pc += variable;    ciclo_temp++;    asd -> Pc = asd -> Pc + 1;}/*void fork(int variable, PCB *asd){    int Pc = asd -> Pc;    }*///é o processo que vai ficar em espera não a variavélvoid disk_save(PCB *asd){	/*printf("DISK_SAVE\n");	event_wait();	if(blocked_counter < 3 )    {    	blocked_counter++;    }    else    {    	block_counter = 0;        event_occurs();    }*/    asd -> Pc = asd -> Pc + 1;}void copy(int variable,PCB *asd){     MEM[asd->inicio + 0]=variable;    ciclo_temp++;    asd->Pc=asd->Pc+1;}void Exit(PCB *asd) {	int id=asd->id;	int Pc=asd->Pc;    Node *pointer = dequeue(RUN);    ciclo_temp++;    printf("Inicio:%d\n",asd->inicio);    for(int i=asd -> inicio + Pc; i >= 0; i--)    {        printf("%d\n",Pc);    	MEM[(asd->inicio)+i]=-1;    }    dispatch();    printf("\n///////////updating MEM//////////////////////////\n");    update_MEM(asd);    for(int i = id + 1; i < mem_processes; i++)    {    	pcbArray[i] -> inicio = (pcbArray[i] -> inicio) - (Pc + 11);    }    }//subtrai a localização na MEM do processo pelo valor//organiza a memória quando o processo é retirado de memóriavoid update_MEM(PCB *asd){	int c = 0;	int pc = asd -> Pc;	int inicio = asd -> inicio;	while(MEM[inicio + 11 + pc + c] != -1)	{		MEM[inicio+c] = MEM[inicio + 11 + pc + c];		c++;	}}//inicia as queues dos estadosvoid ini_estados(){	NEW=new_queue(nProcesses);	READY=new_queue(4);	RUN=new_queue(1);	BLOCKED=new_queue(8);	EXIT=new_queue(8);}/*void output(){	printf();	}*/int main(){    ini_mem();	    ini_estados();    le_ficheiro("input_b.xpto");    bool flag = false;    int n = 1;//processo    int r = 0;//roundRobin        PCB *p = read_process(0);    Node *node = new_node(p);    enqueue(RUN,node);    while(true)    {    	if( !flag && n < nProcesses)    	{    		p = read_process(n);    		flag = true;    	}    	printf("\n////////////////////Clock->%d///////\n",ciclo_temp);    	    	if(ciclo_temp == 160)    	{    		break;    	}    	    	if(ins_array[n] == ciclo_temp && (NEW -> sizeQueue) < (NEW -> limit))    	{    		printf("\nGO_TO_NEW()\n");    		printf("\nProcesso nr:%d instante:%d\n", n, ins_array[n]);    		go_to_new(p);    		n++;    		flag = false;    	}    	if(printf("\nroundRobin-%d\n",r) &&r == 4)    	{    		printf("\ntimeout()\n");    		timeout();    		printf("\ndispatch\n");   			dispatch();    		r = 0;    	}    	//printf("Release\n");    	//release();    	/*    	if(r==0)    	{    		printf("dispatch\n");   			dispatch();	    	}    	*/   		printf("\nRUNNING\n");   		print_MEM();   		running(RUN -> head -> element, r);   		//print_MEM();   		r++;   		printf("\nEvent_occurs\n");   		event_occurs();   		printf("\nAdmit\n");   		admit();   		printf("\n//////NEW/////\n");   		print_queue(NEW);   		printf("\n//////READY/////\n");   		print_queue(READY);   		printf("\n//////BLOCKED/////\n");   		print_queue(BLOCKED);   		printf("\n//////RUN/////\n");   		print_queue(RUN);   		printf("\n//////EXIT/////\n");   		print_queue(EXIT);    }    /*    printf("CICLO_TEMPO---->%d\n",ciclo_temp);    			printf("event_occurs\n");    			event_occurs();    			printf("timeout\n");    			timeout();    			event_wait();    			printf("admit\n");    			admit();    			printf("dispatch\n");    			dispatch();    			printf("RUNNING\n");    			running(RUN->head->element);    			printf("Release\n");    			release();    */        }
=======
#define _GNU_SOURCE
#include <stdio.h>
#include <stdlib.h>
#include <string.h> //para o output
#include "queue2.h"

//Variáveis Globais Configuraveis
#define MEMSIZE 300 // Tamnho do array
#define Quantum 4  //Tamanho do Quantum
#define max_ready 4 //Maximo de processos no ready
#define nProcesses 8  //Numero de processos


Queue *New;
Queue *Ready;
Queue *Run;
Queue *Blocked;
Queue *Exit;

int MEM[MEMSIZE];
char buffer[100];
int program_number;
char *tempobuffer[nProcesses];
PCB *pcbArray[nProcesses];
int ins_array[nProcesses];
int ciclo_temp=0;//ciclo_temp atual 

/*Funcoes do programa */
void le_ficheiro(char* file) {
    FILE* ficheiro;
    char* linha = NULL;
	size_t len = 0;
	ssize_t read;

	ficheiro = fopen(file, "r");
	if(ficheiro == NULL){
		printf("\nFicheiro não encontrado!");
	}
	else{
		int i=0;
		while((read=getline(&linha, &len, ficheiro)) != -1){  //coloca o file todo no tempobuffer
			tempobuffer[i]=strdup(linha);
			i++;
		}
	}
	fclose(ficheiro);
	for(int i=0;i<8;i++)
        printf("linha nº%d:%s",i,tempobuffer[i]);
    printf("\n");
}

void read_process(int n)
{
    int counter=0;
    int counter2=0;//posição da memória para escrever
    //char ins[2];//instrução
    char *temp[5];//char temporario para guardar o ciclo_temp e as instruções
    printf("---%c\n",tempobuffer[n][counter]);
    //guarda ciclo_temp
    while(tempobuffer[n][counter]!=' ')
    {
        temp[counter]=&tempobuffer[n][counter];
        counter++;
    }
    printf("ciclo_temp:%d\n",atoi(*temp));
    printf("Guardou ciclo_temp!\n");
    if(n==0)//primeiro processo
    {
        ins_array[0]=atoi(*temp);
        ciclo_temp=atoi(*temp);
    }
    else{ins_array[n]=ins_array[n]+atoi(*temp);}
    counter=counter+2;
    printf("MEM[counter2]=%d\n",MEM[counter2]);
    //vai até á memória nao utilizada
    while(MEM[counter2]!=-1)
    {
        counter2++;
    }
    printf("AQUI2\n");
    //cria PCB
    PCB *p = new_pcb(n);
    p->inicio=counter2;//guarda o endereço do inicio das variáveis e instruções
    p->ciclo_temp=ins_array[n];//guarda o ciclo_temp no PCB
    printf("AQUI3\n");
    printf("p->inicio:%d\n",p->inicio);
    pcbArray[n]=p;
    printf("pcbArray[n]:%d\n",pcbArray[n]->id);
    go_to_new(p);
	//espaços para variaveis na memoria
	for(int i=0;i<10;i++)
	{
		MEM[counter2+i]=-100;
	}
	counter2=counter2+10;
	printf("counter2:%d\n",counter2);
    while(true)
    {
    	if(tempobuffer[n][counter]=='\0')
    	{
    		break;
    	}
    	char *ins[2];//instrução
		printf("---%c%c\n",tempobuffer[n][counter],tempobuffer[n][counter+1]);
    	ins[0]=&tempobuffer[n][counter-1];
    	ins[1]=&tempobuffer[n][counter];
    	MEM[counter2]=atoi(*ins);
    	//printf("%s\n",ins);
    	printf("MEM[%d]=%d\n",counter2,MEM[counter2]);
    	counter2++;
    	counter=counter+3;
    }
}
void print_MEM()
{
	for(int i=0;i<300;i++)
	{
		printf("%d ",MEM[i]);
	}
	printf("\n");
}
void ini_mem()
{
    for(int i=0;i<300;i++)
    {
        MEM[i]=-1;
    }
}

//GO TO NEW
void go_to_new(PCB *process){
        Node *n = new_node(process);
       	//printf("GO TO NEW|||||\n");
        enqueue(New,n);
}

//New----->Ready
void admit(){
    if( New -> head != NULL){
        if( (Ready -> sizeQueue) < max_ready){
            Node *pointer = dequeue(New);
            enqueue(Ready,pointer);
        }
    }
}

//Ready----->running
void dispatch(){
    if( Ready -> head != NULL)
    {
        Node *pointer = dequeue(Ready);
        //run_counter = 0; //contador para o quantum
        enqueue(Run,pointer);
    }
}

//Running---->Exit
void release()
{
	Node *pointer = dequeue(Run);
    enqueue(Exit,pointer);
}
//Running----->Blocked
void event_wait()
{
    Node *pointer = dequeue(Running);
    enqueue(Blocked, pointer);
}
/*


void got_to_Ready(Node *pointer){//Simplificar funcionamento do programa criando função para atividade repetida
    if((Ready -> size) < max_ready)
    {
        enqueue(Ready, n);
    }
}




void dispatch(){
    if( Ready -> head != NULL){
        Node *pointer = dequeue(Ready);
        run_counter = 0; //contador para o quantum
        enqueue(Running);
        }
}

void release(){//faltam cenas
    enqueue(Exit,n);
}

/*


void timeout(){
    go_to_ready(dequeue(Running));
}

void event_occurs(){//só pode ser chamada qd houver espaço no ready
    go_to_ready(dequeue(Blocked));
}

void running(){//função que vai lidar com os processos no estado running
    if(RUN->head!=NULL)
    {
        if(MEM[(RUN -> head -> element -> inicioinstrucao + RUN -> head->Pc  == 0))]
        {
            make_zero();
        }
        else if(MEM[(RUN->head->element->inicioinstrucao + RUN->head->element->Pc) == 1])
        {

        }

    }
    running_counter = 0;
}

void blocked(){//função qeu vai lidar com os processos no estado blocked,
    if( Blocked -> head != Null){
        if(blocked_counter < 3 ){
            blocked_counter++;
        }
        else{ block_counter = 0;}
    }
}


        enqueue(Ready, n);
    }
}


void timeout(){
    go_to_ready(dequeue(Running));
}

void event_wait(){
    Node *pointer = dequeue(Running);
    enqueue(Blocked, pointer);
}

void event_occurs(){//só pode ser chamada qd houver espaço no ready
    go_to_ready(dequeue(Blocked));
}



void blocked(){//função qeu vai lidar com os processos no estado blocked,
    dequeue(Readý);
    enqueue(Blocked);

}

void make_zero(PCB *asd,int variable){
    locater=*inicioinstrucao - (10-variable);
    MEM[locater]=0;
    
}

void add(PCB*asd,int variable){
    locater=*inicioinstrucao-(10-variable);
    MEM[locater]=variable++;
}

int subtract(Node *variable){
    variable--;
    return variable;
}

int if_check(Node *variable,Node *Pc){
    if( variable == 0){
        ++Pc;//no clue if it's like this
    }
    else{
        Pc += 2;
    }
}

int back(Node *variable, Node *Pc){
    Pc -= variable;
}

int forward(Node *variable, Node *Pc){
    Pc += variable;
}

int disk_save(Node *Id){//é o processo que vai ficar em espera não a variavél
        if(blocked_counter < 3 ){
            blocked_counter++;
        }
        else{
            block_counter = 0;
            event_occurs();
        }
}

//inicia as queues dos estados
void ini_estados()
{
	New=new_queue(8);
	Ready=new_queue(4);
	Run=new_queue(1);
	Blocked=new_queue(8);
	Exit=new_queue(8);
}

int main()
{
    /*
    PCB *arr;
    char name[50];
    printf("Digite o nome do ficheiro: ");
    scanf("%s",name);
    printf("aqui4\n");
    arr=le_ficheiro(name);
    printf("aqui3\n");
    Queue *New = new_queue(300);
    printf("%d",arr[0].id);
    printf("aqui2\n");
    go_to_New(arr[0]);
    printf("aqui\n");
    printf("%d\n",New->head->element->id);
    //print_queue(New);
    printf("here\n");
    //printf("\nAqui esta: %c",MEM[4]);
    */
    ini_estados();
    New = new_queue(300);
	printf("sizeQueue:%d\n",New->sizeQueue);
    printf("limit:%d\n",New->limit);
    le_ficheiro("input_b.xpto");
    ini_mem();
    print_MEM();
    read_process(1);
    print_MEM();
    admit();
    print_queue(Ready);
    dispatch();
    print_queue(Run);
    release();
    print_queue(Exit);
    return 0;
}

>>>>>>> 49e438103b7a243bf6e123d047561885909eb712
