#include <stdio.h>
#include <stdlib.h>
#include "countries_controller.h"
#include "models.h"
#include <stdbool.h>
#include <string.h>

/*
 * function country country_new
 *
 * this function initialize a country and set all value to zero or empty.
 *
 * RETURN: country
 *
 * @params:  char c_id[C_ID_SIZE] -> the id of the country to be create;
 */
country_t country_new(char c_id[C_ID_SIZE])
{
    country_t c = malloc(sizeof(struct country));

    strcpy(c->c_id, c_id);

    c->current = 0;

    c->dropped = 0;

    c->finished = 0;

    c->total = 0;

    return c;
}

/*
 * function country_new_without_malloc
 *
 * this function resets a country value with zero or empty.
 *
 * RETURN: void
 *
 * @params: country country | the country to be reset
 * @params: char c_id[C_ID_SIZE] | the id of the country to be created;
 */
void country_new_without_malloc(country_t cntry, char c_id[C_ID_SIZE])
{

    strcpy(cntry->c_id, c_id);

    cntry->current = 0;

    cntry->dropped = 0;

    cntry->finished = 0;

    cntry->total = 0;
}

/*
 * function country_print
 *
 * this function print a country
 *
 * RETURN: void
 *
 * @parms country_t country | the country to be printed
 * @params char c_id[C_ID_SIZE] | the country id
 */
void country_print(country_t cntry, char c_id[C_ID_SIZE])
{
    if (cntry != NULL && cntry->total)
        printf("+ %s - correntes: %d, diplomados: %d, abandonaram: %d, total: %d\n", cntry->c_id,
               cntry->current, cntry->finished, cntry->dropped, cntry->total);

    else
        printf("+ sem dados sobre %s\n", c_id);
}

/*
 * function countries_get_position
 *
 * this function calculates the country's position using the given country id
 *
 * RETURN: unsigned int | the position of the country in the countries file
 *
 * @params: char c_id[C_ID_SIZE] | id of the country to calculate the position
 */
unsigned int countries_get_position(char c_id[C_ID_SIZE])
{

    return (c_id[0] - 65) * 26 + c_id[1] - 65;
}

/*
 * function save_country_to_file
 *
 * this function saves a given country to the file
 *
 * RETURN: true or false | true if saved
 *
 * @params FILE *country_file | the file that the country will be stored to
 * @params country country_to_save | the country that will be saved to the file
 */
bool save_country_to_file(FILE *country_file, country_t country_to_save)
{
    unsigned int position = countries_get_position(country_to_save->c_id);

    fseek(country_file, position * sizeof(struct country), SEEK_SET);

    if (fwrite(country_to_save, sizeof(struct country), 1, country_file))
        return true;
    return false;
}

/*
 * function read_country_from_file
 *
 * this function reads a country from the file
 *
 * RETURN: country_t | wether it's successful or not
 *
 * @params FILE *country_file | the file from which the info will be retrieved from
 * @params  char c_id[C_ID_SIZE] | the id of the country to read
 */
country_t read_country_from_file(FILE *country_file, char c_id[C_ID_SIZE])
{
    country_t c = country_new("");

    unsigned int position = countries_get_position(c_id);

    fseek(country_file, position * sizeof(struct country), SEEK_SET);

    fread(c, sizeof(struct country), 1, country_file);

    return c;
}

/*
 * function get_country_info
 *
 * this function reads a country from the country's file and prints its information
 *
 * RETURN: void
 *
 * @params FILE *country_file | file to get the country's info from
 * @params  char c_id[C_ID_SIZE] | the id of the country to get the info
 */
void get_country_info(FILE *countries_file, char c_id[C_ID_SIZE])
{
    country_t c = read_country_from_file(countries_file, c_id);

    country_print(c, c_id);

    free(c);
}