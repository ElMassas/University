from ply.lex import lex
from ply.yacc import yacc


# --- Tokens

tokens = ('ID', 'NUM', 'PLUS', 'TIMES', 'EQ', 'LPAREN', 'RPAREN', 'PRINT')

def t_ID(t):
    r'[a-zA-Z_][a-zA-Z0-9_]*'
    if t.value == 'print':
        t.type = 'PRINT'
    return t 

def t_NUM(t):
    r'[0-9]+'
    t.value = int(t.value)
    return t   

t_PLUS = r'\+'
t_TIMES = r'\*'
t_EQ = r'='
t_LPAREN =r'\('
t_RPAREN = r'\)'
t_PRINT = r'print' 

def t_error(t):
    print(f'Illegal character {t.value[0]!r}')
    t.lexer.skip(1)


# --- Grammar 

def p_statements_multiple(p):
    '''
    statements : statements statement
    '''
    p[0] = p[1] + [p[2]]

def p_statements_single(p):
    '''
    statements : statement
    '''
    p[0] = [ p[1] ]
    
def p_assignment_statement(p):
    '''
    statement : ID EQ expr
    '''
    p[0] = ('assign', p[1], p[3])
    
def p_print_statement(p):
    '''
    statement : PRINT LPAREN expr RPAREN
    '''
    p[0] = ('print', p[3])

def p_expr_binop(p):
    '''
    expr : expr PLUS expr
         | expr TIMES expr
    '''
    p[0] = (p[2], p[1], p[3])
    
def p_expr_num(p):
    '''
    expr : NUM
    '''
    print('Got a number', p[1])
    p[0] = ('num', p[1])
    
def p_expr_name(p):
    '''
    expr : ID
    '''
    p[0] = ('id', p[1])
    
def p_expr_group(p):
    '''
    expr : LPAREN expr RPAREN 
    '''
    p[0] = p[2]
 
precedence = (
    ('left', 'PLUS'),
    ('left', 'TIMES')
    )
    
'''
statements : statements statement
           | statement
           
statements : ID EQ expr
           | PRINT LPAREN expr RPAREN
           
expr : expr PLUS expr
     | expr TIMES expr
     | NUM
     | ID
     | LPAREN expr RPAREN
     
'''
if __name__ == "__main__":
    lexer = lex()
    lexer.input('a=1+3*5')
    
    for tok in lexer:
        print(tok)
        
    print('\n')
    lexer.input('print(a)')
    
    for tok in lexer:
        print(tok)
        
    print('\n->parser\n')
    
    parser = yacc()  
    print(parser.parse('a = 3*4 + 5'))
    
    