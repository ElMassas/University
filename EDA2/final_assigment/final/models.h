#ifndef MODEL_EDA2
#define MODEL_EDA2

#define FINISHED 0 // student FINISHED status
#define DROPPED 1  // student DROPPED status
#define ACTIVE 2   // student ACTIVE status
#define DELETED 3  // student DELETED status

#define S_ID_SIZE 7 // size of a student id str
#define C_ID_SIZE 3 // size of a country id str

// struct to represent a student
typedef struct student
{
    char s_id[S_ID_SIZE];

    char c_id[C_ID_SIZE];

    char status;

} * student_t;

// struct to represent a country
typedef struct country
{
    char c_id[C_ID_SIZE];

    int current;

    int dropped;

    int finished;

    int total;

} * country_t;

#endif