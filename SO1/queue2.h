#include <stdbool.h>

typedef struct PCB PCB;
typedef struct Node Node;
typedef struct Queue Queue;
typedef struct Queue
{
    int sizeQueue;
    int limit;
    Node *head;


}Queue;
typedef struct PCB
{
    int id;
    int Pc;
    int size;
    int localizador;
    int inicio;

}PCB;

typedef struct Node
{
    PCB *element;
    Node *next;
    int data;

}Node;

PCB * new_pcb(int id);
Node * new_node(PCB * e);
Queue * new_queue(int limit);

void print_pcb(PCB *p);

void enqueue(Queue *q,Node *n);
Node * dequeue(Queue * q);
void print_queue(Queue * q);

void update_MEM(PCB *asd);
void ini_estados();
void ini_mem();
void print_MEM();
void go_to_new(PCB *process);
void admit();
void dispatch();
void release();
void event_wait();
void go_to_READY(Node *pointer);
void timeout();
void event_occurs();
void running(PCB *asd,int roundrobin);
void blocked();
void timeout();

void make_zero(int variable,PCB *asd);
void add(int variable,PCB *asd);
void subtract(int variable,PCB *asd);
void if_check(int variable,PCB *asd);
void back(int variable, PCB *asd);
void forward(int variable,PCB *asd);
void disk_save(PCB *asd);
void copy(int variable, PCB *asd);
void Exit(PCB *asd);

