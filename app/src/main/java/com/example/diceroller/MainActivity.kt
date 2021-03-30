package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Declare a variable with the button reference
        val rollButton: Button = findViewById(R.id.button)

        // Call the method on click from the button
        rollButton.setOnClickListener { rollDice() }
    }

    /**
    * Roll the dice  and update the screen with the result.
    */
    private fun rollDice() {
        // Create a new Dice object with 6 sides and roll it.
        val dice = Dice(6)
        val rollResult = dice.roll()
        val luckyNumber = 4


        when (rollResult) {
            luckyNumber -> Toast.makeText(this, "You Win!", Toast.LENGTH_SHORT).show()
            1 -> Toast.makeText(this, "So sorry! You rolled a 1. Try again!", Toast.LENGTH_SHORT).show()
            2 -> Toast.makeText(this, "Sadly, you rolled a 2. Try again!", Toast.LENGTH_SHORT).show()
            3 -> Toast.makeText(this, "Unfortunately, you rolled a 3. Try again!", Toast.LENGTH_SHORT).show()
            4 -> Toast.makeText(this, "No luck! You rolled a 4. Try again!", Toast.LENGTH_SHORT).show()
            5 -> Toast.makeText(this, "Don't cry! You rolled a 5. Try again!", Toast.LENGTH_SHORT).show()
            6 -> Toast.makeText(this, "Apologies! you rolled a 6. Try again!", Toast.LENGTH_SHORT).show()
        }


        // Update the screen with the dice roll.
        val resultTextView: TextView = findViewById(R.id.textView)
        resultTextView.text = rollResult.toString()
    }
}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}