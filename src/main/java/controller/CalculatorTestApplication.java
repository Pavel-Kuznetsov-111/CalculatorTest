package controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.skyprospringtestcalculator.exception.DivideByZeroException;

@RestController
@RequestMapping("/calculator")

public class CalculatorController {

	private final CalculatorService service;


	public CalculatorController(CalculatorService service) {
		this.service = service;
	}

	@GetMapping
	public String HelloCalculator(){
		return "Добро пожаловать в калькулятор";
	}

	@GetMapping("/plus")
	public String plus (@RequestParam (required = false) Float num1, @RequestParam(required = false) Float num2){
		ValidateParams(num1, num2);
		return num1 + " + " + num2 + " = " + service.plus(num1, num2);
	}

	@GetMapping("/minus")
	public String minus (@RequestParam (required = false) Float num1, @RequestParam(required = false) Float num2){
		ValidateParams(num1, num2);
		return num1 + " - " + num2 + " = " + service.minus(num1, num2);
	}


	@GetMapping("/multiply")
	public String multiply (@RequestParam (required = false) Float num1, @RequestParam(required = false) Float num2){
		ValidateParams(num1, num2);
		return num1 + " * " + num2 + " = " + service.multiply(num1, num2);
	}

	@GetMapping("/divide")
	public String divide (@RequestParam (required = false) Float num1, @RequestParam(required = false) Float num2){
		ValidateParams(num1, num2);
		try {
			double result = service.divide(num1, num2);
			return num1 + " / " + num2 + " = " + result;
		} catch (DivideByZeroException e) {
			return e.getMessage();
		}

	}

	private void ValidateParams(Float num1, Float num2) {
		if (num1 == null || num2 == null) {
			throw new DivideByZeroException("Не введен один из параметров!!!");
		}
	}

