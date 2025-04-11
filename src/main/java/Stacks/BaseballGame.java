package Stacks;

import java.util.Stack;

public class BaseballGame {
    public static void main(String[] args) {
        String ops [] = {"5","2","C","D","+"};
        System.out.println(calPoints(ops));
    }

    public static int calPoints(String[] operations){

        Stack<Integer> stack = new Stack<>();

        for (String operation : operations){
            if(operation.equals("+")){
                int top = stack.pop(); // remove o topo (ultimo ponto)
                int newTop = top + stack.peek(); // soma com a nova "última" (anterior à ultima)
                stack.push(top); // repõe o que foi removido
                stack.push(newTop); // adiciona o novo ponto/resultado
                // top = 10, stack.peek() = 5, logo newTop = 15 // Resultado final: [5, 10, 15]
            }else if(operation.equals("D")){
                stack.push(stack.peek() * 2); // // duplica o último ponto
                // Se a stack for [5, 10], vai ficar [5, 10, 20]
            }else if(operation.equals("C")){
                stack.pop(); // remove o último ponto
                // [5, 10, 15] → [5, 10]
            }else{
                stack.push(Integer.parseInt(operation)); // Transforma o número de String para int e mete-o na stack
            }
        }
        int sum = 0;
        while (!stack.isEmpty()){
            sum += stack.pop();
        }
        return sum;
    }

    // passo a passo
    // "5" → [5]
    // "2" → [5, 2]
    // "C" → remove 2 → [5]
    // "D" → duplica 5 → [5, 10]
    // "+" → soma 10 + 5 = 15 → [5, 10, 15]

    // métodos principais de stacks
    // push(E item)	Adiciona um item ao topo da pilha
    // pop()	Remove e retorna o item no topo da pilha
    // peek()	Retorna o item do topo sem remover
    // empty()	Verifica se a pilha está vazia
    // search(Object o)	Procura o objeto na pilha e retorna a posição (1-based) a partir do topo
}
