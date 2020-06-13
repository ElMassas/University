#include <stdio.h>
#include <string.h>

#include "students_controller.h"
#include "countries_controller.h"
#include "models.h"

void manager(FILE *country_file, FILE *student_file)
{
    char cmd;

    while (scanf("%c", &cmd) != EOF)
    {
        switch (cmd)
        {

        case 'I':
        {
            student_t s = student_new();
            scanf("%s %s", s->s_id, s->c_id);
            insert_new_student(country_file, student_file, s);
            free(s);
            break;
        }

         case 'R':
        {
            char s_id[S_ID_SIZE];
            scanf("%s", s_id);
            remove_a_student_id(country_file, student_file, s_id);
            break;
        }

        case 'T':
        {
            char s_id[S_ID_SIZE];
            scanf("%s", s_id);
            set_student_finished(country_file, student_file, s_id);
            break;
        }

        case 'A':
        {
            char s_id[S_ID_SIZE];
            scanf("%s", s_id);
            set_student_dropped(country_file, student_file, s_id);
            break;
        }

        case 'P':
        {
            char c_id[C_ID_SIZE];
            scanf("%s", c_id);
            get_country_info(country_file, c_id);
            break;
        }

        case 'X':
            fclose(country_file);
            fclose(student_file);
            return;
        default:
            break;
        }
    }
}

/** MAIN **/
int main(int argc, char const *argv[])
{

    FILE *countries_file, *students_file;

    if ((countries_file = fopen("countries", "rb+")) == NULL)
        if ((countries_file = fopen("countries", "wb+")) == NULL)
            perror("error opening countries file");

    if ((students_file = fopen("students", "rb+")) == NULL)
        if ((students_file = fopen("students", "wb+")) == NULL)
            perror("error opening students file");

    manager(countries_file, students_file);

    return 0;
}
