#ifndef COUNTRY_CONTROLLER_EDA2

#include <stdio.h>
#include <stdlib.h>
#include "models.h"
#include <stdbool.h>

country_t country_new(char c_id[C_ID_SIZE]);

void  country_new_without_malloc(country_t c, char c_id[C_ID_SIZE]);

void country_print(country_t country,  char c_id[C_ID_SIZE]);

bool save_country_to_file(FILE *country_file, country_t country_to_save);

country_t read_country_from_file(FILE *country_file, char c_id[C_ID_SIZE]);

void get_country_info(FILE *countries_file, char c_id[C_ID_SIZE]);

unsigned  int countries_get_position(char  c_id[C_ID_SIZE]);

#endif