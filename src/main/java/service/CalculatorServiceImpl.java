package pro.sky.skyprospringtestcalculator.service;

import org.springframework.stereotype.Service;
import pro.sky.skyprospringtestcalculator.exception.DivideByZeroException;

@Service
public class CalculatorServiceImpl implements CalculatorService{

    public float plus (Float num1, Float num2){
        return num1 + num2;
    }


    public float minus (Float num1, Float num2){
        return num1 - num2;
    }

    public float multiply (Float num1, Float num2){
        return num1 * num2;
    }

    public float divide (Float num1, Float num2){
        if (num2 == 0) {
            throw new DivideByZeroException("Деление на ноль невозможно");
        }
        return num1 / num2;
    }
}
