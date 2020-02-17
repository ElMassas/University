#include <stdio.h>
#include <stdlib.h>
#include <stdio.h>
#include "queue2.h"


Node * new_node(PCB * e)
{
    Node *n=malloc(sizeof(Node));
    n->element=e;
    n->next=NULL;
    n->data=0;
    return n;
}

/*-------------------*/
/* Funcoes da Queue */



Queue * new_queue(int limit)
{
   Queue *q=malloc(sizeof(*q));
   q->limit=limit;
   q->head=NULL;
   q->sizeQueue=0;

   return q;

}

void enqueue(Queue *q,Node *n)
{
    if(q->sizeQueue<q->limit)  //se sizeQueue< que ao seu limite entao
    {	
        if(q->head==NULL)
        {
            q->head=n;
        }
        else
        {
            Node * current= q->head;
            while(current->next!=NULL)
            {
                current=current->next;
            }
            current->next=n;
        }
        q->sizeQueue++;
    }
}

Node * dequeue(Queue *q)
{
    if(q->sizeQueue!=0)
    {
        Node *p=q->head;
        q->head=q->head->next;
        q->sizeQueue--;
        p->next=NULL;

        return p;
    }
    return NULL;

}

void print_queue(Queue *q)
{
    if(q->head!=NULL)
    {
        Node * current=q->head;
        while(current!=NULL)
        {
            printf("id: %d ",current->element->id);
            current = current -> next;
        }
        printf("\n");
        free(current);
    }
}

void queue_destroy(Queue *q)
{
    if(q->head!=NULL)
    {
        Node *prev;
        Node *current=q->head;

        while(current!=NULL)
        {
            prev=current;
            free(prev);
            current=current->next;
        }
        free(current);
        free(prev);
    }
    free(q->head);
    free(q);
}

PCB * new_pcb(int id)
{
    PCB *p = malloc(sizeof(*p));
    p->id=id;
    p->Pc=0;
    p->size=0;
    p->localizador=0;
    p->inicio=0;


    return p;
}



