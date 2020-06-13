
#include <stdlib.h>
#include <stdio.h>
#include <stdbool.h>
#include <string.h>

#include "models.h"
#include "countries_controller.h"
#include "students_controller.h"

#define FNV_OFFSET_BASIS 2166136261 // BASIS OFFSET used FNV hashtable

#define FNV_PRIME 16777619 // FNV prime number used to 31 bit string hash

#define HT_STUDENTS_SIZE 30000001
/*
 student hashtable size, is a prime number should be at least 2 times
 amount the hashtable data we increased it bit, just ti have more space and
 less collisions
*/


/*
 * function student_new
 *
 * this function should initialize a student with status ACTIVE and  c_di
 * and s_id as an empty string
 *
 * RETURN: a student pointer
 *
 * no params
 */
student_t student_new()
{
    student_t student = malloc(sizeof(struct student));

    student->status = ACTIVE;

    strcpy(student->s_id, "");

    strcpy(student->c_id, "");

    return student;
}

/*
 * function student_print
 *
 * this function prints a student,
 * if the given student has a DELETED status nothing happens
 *
 * RETURNS: void
 * 
 * @parms student student | value of student type
 */
void student_print(student_t student)
{
    if (student->status != DELETED)
        printf("+  %s - country: %s, status: %d\n", student->s_id, student->c_id, student->status);
}

/*
 * function hash
 *
 * this function returns the hash value for the gived student id
 *
 * RETURNS: unsigned int | hashed value 
 * 
 * @parms const char s_id | student id
 */
unsigned int hash(const char s_id[S_ID_SIZE])
{

    unsigned int hash = FNV_OFFSET_BASIS;

    for (int i = 0; i < S_ID_SIZE; i++)
    {
        hash *= FNV_PRIME;

        hash ^= s_id[i];
    }

    return hash % HT_STUDENTS_SIZE;
}

/*
 * function int student_get_position
 *
 * this function searchs for a valid position using a given student id, 
 * in the student file.
 *
 * RETURN: unsigned int | position for the given id
 *
 * @params FILE *student_file | file where students are saved
 * @params char s_id[S_ID_SIZE] | ID of the student from whom to get the position in file
 */
unsigned int student_get_position(FILE *students_file, char s_id[S_ID_SIZE])
{
    unsigned int hashed = hash(s_id);

    unsigned index = hashed;

    int h = 1; // h is the value used to execute quadratic probing operation

    student_t student = student_new();

    fseek(students_file, index * sizeof(struct student), SEEK_SET);

    if (fread(student, sizeof(struct student), 1, students_file) == 0)
    {
        free(student);
        return index;
    }

    //search for a valid position
    while (strcmp(student->s_id, "") != 0 && student->status != DELETED && strcmp(student->s_id, s_id) != 0)
    {

        index = (hashed + (h * h)) % HT_STUDENTS_SIZE;

        h++;

        fseek(students_file, index * sizeof(struct student), SEEK_SET);

        if (fread(student, sizeof(struct student), 1, students_file) == 0)
        {

            free(student);
            return index;
        }
    }

    int last_index = index;

    if (student->status == DELETED)
        while (strcmp(student->s_id, "") != 0 && strcmp(student->s_id, s_id) != 0)
        {
            index = (hashed + (h * h)) % HT_STUDENTS_SIZE;

            h++;

            fseek(students_file, index * sizeof(struct student), SEEK_SET);

            if (fread(student, sizeof(struct student), 1, students_file) == 0 || last_index == index)
            {
                free(student);
                return index;
            }
        }

    free(student);

    return index;
}

/*
 * function save_student_to_file
 *
 * this function saves a given student to the students file
 *
 * RETURN: true or false |  true if it saves successfully, false if not
 *
 * @params FILE *students_file | the file that the student will be stored to
 * @params student student_to_save | the student that will be saved to the file
 */
bool save_student_to_file(FILE *students_file, student_t student_to_save)
{

    if (student_to_save != NULL)
    {

        unsigned int position = student_get_position(students_file, student_to_save->s_id) * sizeof(struct student);

        fseek(students_file, position, SEEK_SET);

        if (fwrite(student_to_save, sizeof(struct student), 1, students_file))
            return true;
        // position = 0;
    }

    return false;
}

/*
 * function read_student_from_file
 *
 * this function reads a student from the file
 *
 * RETURN: student | where it goes properly or not
 *
 * @params FILE *students_file | the file that the student will be read from
 * @params student student_to_save | the student that will be read from the file
 */
student_t read_student_from_file(FILE *students_file, char s_id[S_ID_SIZE])
{

    student_t student = student_new();

    unsigned int position = student_get_position(students_file, s_id) * sizeof(struct student);

    fseek(students_file, position, SEEK_SET);

    fread(student, sizeof(struct student), 1, students_file);

    return student;
}

/*
 * function find_student
 *
 * this function tries to find a student in the students file using the given student id
 *
 * RETURN: NULL or student |  if found successfully returns student
 *
 * @params FILE *students_file | the file where the students are
 * @params student student_to_save | the student that we're looking for
 */
student_t find_student(FILE *student_file, char s_id[S_ID_SIZE])
{
    student_t student = read_student_from_file(student_file, s_id);

    if (student->status != DELETED && strcmp(student->s_id, s_id) == 0)
        return student;

    free(student);

    return NULL;
}

/*
 * function bool student_error
 *
 * this function check if the student exists or if its in active status, if not its
 * print the corresponding error.
 * RETURN: 
 *  its returns true if the student doesn't  exists or isn't in active status
 *  if not its returns false;
 *
 * @params student *stdnt, the student to be checked
 * @params char s_id[S_ID_SIZE] the student id  that will be check for error
 */
bool student_error(student_t stdnt, char s_id[S_ID_SIZE])
{
    bool error = true;

    if (stdnt == NULL)
        printf("+ estudante %s inexistente\n", s_id);

    else if (stdnt->status == FINISHED)
        printf("+ estudante %s terminou\n", s_id);

    else if (stdnt->status == DROPPED)
        printf("+ estudante %s abandonou\n", s_id);

    else
        error = false;

    return error;
}

/*
 *  function insert_new_student
 *
 *  this function insert a student to the a system if he doesn't yet exist and updates the students country data
 * 
 *  RETURN: true or false | true if student is properly inserted
 *
 * @params FILE *countries_file | to be update to the new student
 * @params FILE *students_file | the file that the student will be stored
 * @params student student | the student that will be save to the file
 */
bool insert_new_student(FILE *countries_file, FILE *students_file, student_t student)
{

    student_t found_student = find_student(students_file, student->s_id);

    if (found_student == NULL)
    {

        save_student_to_file(students_file, student);
        country_t new_country = read_country_from_file(countries_file, student->c_id);

        if (strcmp(new_country->c_id, "") == 0)
            country_new_without_malloc(new_country, student->c_id);

        new_country->current++;

        new_country->total++;

        save_country_to_file(countries_file, new_country);

        free(new_country);

        free(found_student);

        return true;
    }

    printf("+ estudante %s existe\n", student->s_id);

    return false;
}

/*
 *  function remove_a_student_id
 *
 *  this function removes a valid student from the system
 * 
 *  RETURN: true or false | true if removed properly
 *
 * @params FILE *countries_file | to be updated after status updated
 * @params FILE *students_file | to updated the student information
 * @params student student the | to change the status
 */
bool remove_a_student_id(FILE *countries_file, FILE *students_file, char s_id[S_ID_SIZE])
{
    student_t student = find_student(students_file, s_id);

    if (!student_error(student, s_id))
    {
        student->status = DELETED;

        save_student_to_file(students_file, student);

        country_t new_country = read_country_from_file(countries_file, student->c_id);

        if (strcmp(new_country->c_id, "") == 0)
            country_new_without_malloc(new_country, student->c_id);

        new_country->current--;

        new_country->total--;

        save_country_to_file(countries_file, new_country);

        free(new_country);
        free(student);

        return true;
    }
    return false;
}

/*
 * function set_student_finished
 *
 * this function sets the student to have finished
 * 
 * RETURN: true or false | true if removed properly
 *
 * @params FILE *countries_file | to be updated after status updated
 * @params FILE *students_file | to updated the student information
 * @params student student the | to change the status
 */
bool set_student_finished(FILE *countries_file, FILE *students_file, char s_id[S_ID_SIZE])
{

    student_t student = find_student(students_file, s_id);

    if (!student_error(student, s_id))
    {
        student->status = FINISHED;

        save_student_to_file(students_file, student);

        country_t new_country = read_country_from_file(countries_file, student->c_id);

        if (strcmp(new_country->c_id, "") == 0)
            country_new_without_malloc(new_country, student->c_id);

        new_country->current--;

        new_country->finished++;

        save_country_to_file(countries_file, new_country);

        free(new_country);
        free(student);

        return true;
    }

    return false;
}

/*
 * function set_student_dropped
 *
 * this function set a student to have dropped out
 * 
 * RETURN: true or false | true if removed properly
 *
 * @params FILE *countries_file | to be updated after status updated
 * @params FILE *students_file | to updated the student information
 * @params student student the | to change the status
 */
bool set_student_dropped(FILE *countries_file, FILE *students_file, char s_id[S_ID_SIZE])
{
    student_t student = find_student(students_file, s_id);

    if (!student_error(student, s_id))
    {
        student->status = DROPPED;

        save_student_to_file(students_file, student);

        country_t new_country = read_country_from_file(countries_file, student->c_id);

        if (strcmp(new_country->c_id, "") == 0)
            country_new_without_malloc(new_country, student->c_id);

        new_country->current--;

        new_country->dropped++;

        save_country_to_file(countries_file, new_country);

        free(new_country);

        free(student);
        return true;
    }

    return false;
}
