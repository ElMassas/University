import random
#########################################################################################################
# create_code- Esta função cria o código que o usuario tem que advinhar, usando list compreehnsion para
#              criar uma lista com 4 elementos, sendo cada elemento um Intenger
#
# Argumentos:
#  creator = lista vazia
#
# Valor de retorno:
#  creator = lista cria durante o decorrer da função
#
#########################################################################################################
def create_code(creator=list):
    creator = [random.randint(0, 9) for index in range(0, 4)]
    return creator

#########################################################################################################
# main - A função main é a função principal que faz o chamamento das funções touro e porco, pede o input
#        ao usuario e verifica se o código esta certo.
#
#
# Argumentos:
#  não tem
#
# Valor de retorno:
#  não tem
#
#########################################################################################################
def main():
    state = True
    user_inputs, T, P = [], [], []
    code = create_code()
    while state:
        get_user_input = str(input('Please insert your 4 digit guess: '))
        user_inputs.append(get_user_input)
        t, p = 0, 0
        for index in range(0, len(get_user_input)):
            touro(index, get_user_input, code)
            if touro(index, get_user_input, code) == 'touro':
                t += 1
            elif touro(index, get_user_input, code) == 'porco':
                p += 1
        T.append(t), P.append(p)
        if t == 4:
            print("Acertou!!!\n\n\nAs suas tentativas foram:")
            state = False
        else:
            print(t, 'T', p, 'P')
    for attempt in range(0, len(user_inputs)):
        print(user_inputs[attempt], T[attempt], 'T', P[attempt], 'P')

#########################################################################################################
# touro - A função touro avalia o elemento atualmente a ser indexado e verifica se é o mesmo elemento
#         que se encontra no códgio gerado pelo computador e se esta na mesma poisção, se não cumprir
#         com a verfiicação vai chamar a função porco
#
# Argumentos:
#   index - posição na lista user_input
#   user_input - input do usuario
#   code - código gerado pelo computador
#
# Valor de retorno:
#   resultaddo - Se é porco, touro ou não pertence ao código gerado pelo computador
#
##########################################################################################################
def touro(index, user_input, code):
    resultado = ''
    if (int(user_input[index])) == (code[index]):
        resultado = 'touro'
    elif porco(index, user_input, code) == 1:
        resultado = 'porco'
    return resultado

###########################################################################################################
# porco - Semelhante a função touro, faz um verificação de um elemento que o usuario inseriu, porém
#          verifica se encontra no código gerado pelo computador, sem especificar nenhuma posição espefica
#
#
# Argumentos:
#   index - posição na lista user_input
#   user_input - input do usuario
#   code - código gerado pelo computador
#
# Valor de retorno:
#   p - simples variavel com valor integer para realizar uma verificção na função touro
#
###########################################################################################################

def porco(index, user_input, code):

    p = 0
    if int(user_input[index]) in code:
        p += 1
    return p


main()
