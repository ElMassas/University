#ifndef COUNTRY_CONTROLLER_EDA2

#include <stdlib.h>
#include <stdio.h>
#include <stdbool.h>
#include "models.h"

void student_print(student_t student);

student_t student_new();

bool save_student_to_file(FILE *students_file, student_t student_to_save);

unsigned int student_get_position(FILE *students_file, char s_id[S_ID_SIZE]);

bool insert_new_student(FILE *countries_file, FILE *students_file, student_t stdnt);

bool remove_a_student_id(FILE *countries_file, FILE *students_file, char s_id[S_ID_SIZE]);

bool set_student_finished(FILE *countries_file, FILE *students_file, char s_id[S_ID_SIZE]);

bool set_student_dropped(FILE *countries_file, FILE *students_file, char s_id[S_ID_SIZE]);

#endif