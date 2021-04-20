package com.example.calculatorjeff

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var numberInput = false
    var decimalDot = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun operatorAdded(value: String) : Boolean {
        return if (value.startsWith("-")){
            false
        }else{ value.contains("+") ||
                value.contains("*") ||
                value.contains("/") ||
                value.contains("-")}
    }

    fun onOperation(view: View) {
        if (numberInput && !operatorAdded(calcDisplay.text.toString())) {
            when (view.id) {
                add.id -> {
                    calcDisplay.append("+")
                }
                subtract.id -> {
                    calcDisplay.append("-")
                }
                multiply.id -> {
                    calcDisplay.append("*")
                }
                divide.id -> {
                    calcDisplay.append("/")
                }
            }

            numberInput = false
            decimalDot = false
        }
    }

        fun onEquals(view: View) {
            if(numberInput){
                var screenInput = calcDisplay.text.toString()
                var negativeSign = ""
                if(screenInput.startsWith("-")){
                    negativeSign = "-"
                    screenInput = screenInput.substring(1)
                }
                if(screenInput.contains("-")){
                    val splitInput = screenInput.split("-")
                    var inputOne = splitInput[0]
                    val inputTwo = splitInput[1]
                    if (!negativeSign.isEmpty()){
                        inputOne = negativeSign + inputOne
                    }
                    val result = (inputOne.toDouble()-inputTwo.toDouble())
                    calcDisplay.text=result.toString()
                }else if(screenInput.contains("+")){
                    val splitInput = screenInput.split("+")
                    var inputOne = splitInput[0]
                    val inputTwo = splitInput[1]
                    if (!negativeSign.isEmpty()){
                        inputOne = negativeSign + inputOne
                    }
                    val result = (inputOne.toDouble()+inputTwo.toDouble())
                    calcDisplay.text=result.toString()
                }else if(screenInput.contains("*")) {
                    val splitInput = screenInput.split("*")
                    var inputOne = splitInput[0]
                    val inputTwo = splitInput[1]
                    if (!negativeSign.isEmpty()){
                        inputOne = negativeSign + inputOne
                    }
                    val result = (inputOne.toDouble()*inputTwo.toDouble())
                    calcDisplay.text=result.toString()
                }else if(screenInput.contains("/")){
                    val splitInput = screenInput.split("/")
                    var inputOne = splitInput[0]
                    val inputTwo = splitInput[1]
                    if (!negativeSign.isEmpty()){
                        inputOne = negativeSign + inputOne
                    }
                    val result = (inputOne.toDouble()/inputTwo.toDouble())
                    calcDisplay.text=result.toString()
                }

            }
        }

        fun onClear(view: View) {
            calcDisplay.text = ""
            decimalDot = false
            numberInput = false
        }

        fun onDecimalPoint(view: View) {
            if (numberInput && !decimalDot) {
                calcDisplay.append(".")
                numberInput = false
                decimalDot = true
            }
        }

        fun numberInput(view: View) {
//        calcDisplay.append((view as Button).text)
            when (view.id) {
                one.id -> {
                    calcDisplay.append("1")
                }
                two.id -> {
                    calcDisplay.append("2")
                }
                three.id -> {
                    calcDisplay.append("3")
                }
                four.id -> {
                    calcDisplay.append("4")
                }
                five.id -> {
                    calcDisplay.append("5")
                }
                six.id -> {
                    calcDisplay.append("6")
                }
                seven.id -> {
                    calcDisplay.append("7")
                }
                eight.id -> {
                    calcDisplay.append("8")
                }
                nine.id -> {
                    calcDisplay.append("9")
                }
                zero.id -> {
                    calcDisplay.append("0")
                }
            }
            numberInput = true
        }


}