package com.myTest25;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

/**
 * 解释器模式
 * 1、基本介绍：在编译原理中，一个算术表达式通过词法分析器形成词法单元，而后这些词法单元在通过语法分析器构建语法分析树，最终形成一颗抽象
 *             的语法分析树。这里的词法分析器和语法分析器都可以看做是解析器
 * 2、解释器模式（Interpreter Pattern）：是指定一个语言（表达式），定义它的文法的一种表示，并定义一个解释器，使用该解释器来解释语言中的
 *   句子(表达式)
 * 3、应用场景
 *    ①应用可以将一个需要解释执行的语言中的句子表示为一个抽象语法树
 *    ②一些重复出现的问题可以用一种简单的语言来表达
 *    ③一个简答语法需要解释的场景
 * 4、这样的例子还有，比如编译器、运算表达式计算、正则表达式、机器人等
 *
 * spring框架中 SpelExpressionParser就使用到解释器模式
 */
public class Interpreter {
    public static void main(String[] args) throws IOException {
        String expStr = getExpStr();
        HashMap<String,Integer> var = getValue(expStr);
        Calculator calculator = new Calculator(expStr);
        System.out.println("运算结果:" + expStr + "=" + calculator.run(var));
    }

    public static String getExpStr() throws IOException{
        System.out.println("请输入表达式");
        return (new BufferedReader(new InputStreamReader(System.in))).readLine();
    }

    // 此处有问题:应该为控制台输入了 a+b后分解求值,当前未满足
    public static HashMap<String,Integer> getValue(String expStr){
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        return map;
    }
}

class AddExpression extends SymbolExpression{
    public AddExpression(Expression left , Expression right){
        super(left,right);
    }

    public int interpreter(HashMap<String,Integer> var ){
        return super.left.interpreter(var) + super.right.interpreter(var);
    }
}

class SubExpression extends SymbolExpression{
    public SubExpression(Expression left , Expression right){
        super(left,right);
    }

    public int interpreter(HashMap<String,Integer> var ){
        return super.left.interpreter(var) - super.right.interpreter(var);
    }
}

class SymbolExpression extends Expression{
    protected Expression left;
    protected Expression right;

    public SymbolExpression(Expression left,Expression right){
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpreter(HashMap<String, Integer> var) {
        return 0;
    }
}



class Calculator{
    private Expression expression;

    public Calculator(String expStr){
        Stack<Expression> stack = new Stack<>();
        char[] charArray = expStr.toCharArray();

        Expression left = null;
        Expression right = null;
        for (int i = 0; i < charArray.length; i++) {
            switch (charArray[i]){
                case '+':
                    left = stack.pop();
                    right = new VarExpression(String.valueOf(charArray[++i]));
                    stack.push(new AddExpression(left,right));
                    break;
                case '-':
                    left = stack.pop();
                    right = new VarExpression(String.valueOf(charArray[++i]));
                    stack.push(new SubExpression(left,right));
                    break;
                default:
                    stack.push(new VarExpression(String.valueOf(charArray[i])));
                    break;
            }
        }
        this.expression = stack.pop();
    }

    public int run(HashMap<String,Integer> var){
        return this.expression.interpreter(var);
    }
}


/**
 * 抽象类表达式，通过HashMap键值对，可以获取到变量的值
 *
 */
abstract class Expression{

    // 解释公式和数值，key就是公式(表达式)，value就是具体值
    public abstract int interpreter(HashMap<String,Integer> var);
}

// 变量解析器
class VarExpression extends Expression{
    private String key;

    public VarExpression(String key){
        this.key = key;
    }

    // 根据变量名称返回值
    @Override
    public int interpreter(HashMap<String,Integer> var){
        return var.get(this.key);
    }
}














