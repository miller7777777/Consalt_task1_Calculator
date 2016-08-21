package com.consalt.calculator;/*
1. Calculator
Написать калькулятор для вычисления простейших арифметических выражений. Арифметическим выражением считается выражение, включающее:
1. Цифры
2. Точка в качестве десятичного разделителя
3. Круглые скобки
4. Знаки операций («+», «-», «*», «/»)
Приоритет операций: скобки, умножение-деление, сумма-вычитание. Округление производится до 4-го знака после запятой, округляется только конечный результат. В качестве входного параметра в метод передается строка с арифметическим выражением, в результате ожидается строка с вычисленным значением либо null, если в выражение не может быть вычислено.
 */

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {


    public static void main(String[] args) {

        String inputStr = "-(2+5*10-(25+95)*9.992)/3.77";   //Выражение в качестве примера
        String resStr = parse(inputStr);
        System.out.println(resStr);                 //Пример вывода результата

    }

    //метод, принимающий на вход строку с выражением и возвращающий строку с результатом.
    private static String parse(String str) {

        double result;
        String res;
        Parser myParser = new Parser();     //Создаем объект класса Parser
        try {
            result = myParser.evaluate(str);    //объект Parser принимает выражение в виде строки, разбирает  и вычисляет его и возвращает результат
            double newResult = new BigDecimal(result).setScale(4, RoundingMode.HALF_UP).doubleValue();//округляем результат
            res = String.valueOf(newResult);  //результат преобразуется в строку

        } catch (Exception e) {
            res = null; //если выражение некорректно или результат невозможно вычислить, Parser выбрасывает исключение, в качестве результата возвращаем null
        }


        return res;
    }
}
