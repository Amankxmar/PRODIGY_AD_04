package com.example.tictactoe

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.cardview.widget.CardView
import com.example.tictactoe.databinding.ActivityMainBinding
import com.google.android.material.card.MaterialCardView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    var countOfEmpty: Int = 8
    var humanScore: Int = 0
    var computerScore: Int = 0
    var xoStatus = arrayOf<String>(
        "empty",
        "empty",
        "empty",
        "empty",
        "empty",
        "empty",
        "empty",
        "empty",
        "empty"
    )

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.txtStatus.text = "Game Playing"
        binding.txtCompScore.text = "Computer: $computerScore"
        binding.txtHumanScore.text = "You: $humanScore"
    }

    fun cardClicked(view: View) {
        var card: MaterialCardView = view as MaterialCardView
        var tag: String = card.tag as String
        println(tag)
        if (!card.isChecked) {
            when (tag) {

                "0" -> {
                    binding.img0.setImageResource(R.drawable.x_icon)
                    binding.img0.visibility = View.VISIBLE
                    card.isChecked = true
                    card.isEnabled = false
                    if (xoStatus[0] == "empty") {
                        xoStatus[0] = "x"
                    }
                }

                "1" -> {
                    binding.img1.setImageResource(R.drawable.x_icon)
                    binding.img1.visibility = View.VISIBLE
                    card.isChecked = true
                    card.isEnabled = false
                    if (xoStatus[1] == "empty") {
                        xoStatus[1] = "x"
                    }
                }

                "2" -> {
                    binding.img2.setImageResource(R.drawable.x_icon)
                    binding.img2.visibility = View.VISIBLE
                    card.isChecked = true
                    card.isEnabled = false
                    if (xoStatus[2] == "empty") {
                        xoStatus[2] = "x"
                    }
                }

                "3" -> {
                    binding.img3.setImageResource(R.drawable.x_icon)
                    binding.img3.visibility = View.VISIBLE
                    card.isChecked = true
                    card.isEnabled = false
                    if (xoStatus[3] == "empty") {
                        xoStatus[3] = "x"
                    }
                }

                "4" -> {
                    binding.img4.setImageResource(R.drawable.x_icon)
                    binding.img4.visibility = View.VISIBLE
                    card.isChecked = true
                    card.isEnabled = false
                    if (xoStatus[4] == "empty") {
                        xoStatus[4] = "x"
                    }
                }

                "5" -> {
                    binding.img5.setImageResource(R.drawable.x_icon)
                    binding.img5.visibility = View.VISIBLE
                    card.isChecked = true
                    card.isEnabled = false
                    if (xoStatus[5] == "empty") {
                        xoStatus[5] = "x"
                    }
                }

                "6" -> {
                    binding.img6.visibility = View.VISIBLE
                    binding.img6.setImageResource(R.drawable.x_icon)
                    card.isChecked = true
                    card.isEnabled = false
                    if (xoStatus[6] == "empty") {
                        xoStatus[6] = "x"
                    }
                }

                "7" -> {
                    binding.img7.visibility = View.VISIBLE
                    card.isChecked = true
                    card.isEnabled = false
                    binding.img7.setImageResource(R.drawable.x_icon)
                    if (xoStatus[7] == "empty") {
                        xoStatus[7] = "x"
                    }
                }

                "8" -> {
                    card.isChecked = true
                    card.isEnabled = false
                    binding.img8.visibility = View.VISIBLE
                    binding.img8.setImageResource(R.drawable.x_icon)
                    if (xoStatus[8] == "empty") {
                        xoStatus[8] = "x"
                    }
                }
            }
        }
        if (countOfEmpty > 1) {
            computerPlay()
            println(" auhsduahsduahsd" + countOfEmpty)
            countOfEmpty(xoStatus)
            selectWin()

        } else if (countOfEmpty == 1) {
            countOfEmpty(xoStatus)
            selectWin()
        }

    }

    fun countOfEmpty(arrayEmpty: Array<String>) {
        var count: Int = 0
        for (string in arrayEmpty) {
            if (string.equals("empty")) {
                count++
            }
        }
        countOfEmpty = count
    }

    fun computerPlay() {
        if (countOfEmpty > 1) {
            var random = Random.nextInt(9)
            if (xoStatus[random] != "empty") {
                while (xoStatus[random] != "empty") {
                    random = Random.nextInt(9)
                }
            }
            var imageName = "img${random}"
            var cardName = "card${random}"
            var imageId: Int = resources.getIdentifier(imageName, "id", packageName)
            var cardId: Int = resources.getIdentifier(cardName, "id", packageName)
            var img: ImageView = findViewById(imageId)
            var card: MaterialCardView = findViewById(cardId)
            xoStatus[random] = "o"
            img.setImageResource(R.drawable.o_icon)
            img.visibility = View.VISIBLE
            card.isChecked = true
            card.isEnabled = false
        }
    }

    private fun restart() {
        countOfEmpty = 8

        xoStatus[0] = "empty"
        xoStatus[1] = "empty"
        xoStatus[2] = "empty"
        xoStatus[3] = "empty"
        xoStatus[4] = "empty"
        xoStatus[5] = "empty"
        xoStatus[6] = "empty"
        xoStatus[7] = "empty"
        xoStatus[8] = "empty"

        binding.img0.visibility = View.INVISIBLE
        binding.img1.visibility = View.INVISIBLE
        binding.img2.visibility = View.INVISIBLE
        binding.img3.visibility = View.INVISIBLE
        binding.img4.visibility = View.INVISIBLE
        binding.img5.visibility = View.INVISIBLE
        binding.img6.visibility = View.INVISIBLE
        binding.img7.visibility = View.INVISIBLE
        binding.img8.visibility = View.INVISIBLE

        binding.card0.isEnabled = true
        binding.card0.isChecked = false

        binding.card1.isEnabled = true
        binding.card1.isChecked = false

        binding.card2.isEnabled = true
        binding.card2.isChecked = false

        binding.card3.isEnabled = true
        binding.card3.isChecked = false

        binding.card4.isEnabled = true
        binding.card4.isChecked = false

        binding.card5.isEnabled = true
        binding.card5.isChecked = false

        binding.card6.isEnabled = true
        binding.card6.isChecked = false

        binding.card7.isEnabled = true
        binding.card7.isChecked = false

        binding.card8.isEnabled = true
        binding.card8.isChecked = false

        binding.txtStatus.text = "Game Playing"

    }

    private fun makeNonTouchable() {
        binding.card0.isEnabled = false
        binding.card1.isEnabled = false
        binding.card2.isEnabled = false
        binding.card3.isEnabled = false
        binding.card4.isEnabled = false
        binding.card5.isEnabled = false
        binding.card6.isEnabled = false
        binding.card7.isEnabled = false
        binding.card8.isEnabled = false
        binding.card0.isChecked = true
        binding.card1.isChecked = true
        binding.card2.isChecked = true
        binding.card3.isChecked = true
        binding.card4.isChecked = true
        binding.card5.isChecked = true
        binding.card6.isChecked = true
        binding.card7.isChecked = true
        binding.card8.isChecked = true
    }

    private fun selectWin() {
        var stringWin = checkWin()
        if (stringWin == "x") {
            humanScore += 1
            binding.txtHumanScore.text = "You: $humanScore"
            makeNonTouchable()
            binding.txtStatus.text = "You Win"

        } else if (stringWin == "o") {
            computerScore += 1
            makeNonTouchable()
            binding.txtCompScore.text = "Computer: $computerScore"
            binding.txtStatus.text = "Computer Win"


        } else {
            if (countOfEmpty == 0 && stringWin == "draw") {
                makeNonTouchable()
                binding.txtStatus.text = "Draw!"
            }
        }
    }

    private fun checkWin(): String {
        var lineString: String = ""
        var statusWinner: String = "draw"
        for (a in 0..7) {
            lineString = ""
            when (a) {
                0 -> {
                    lineString = xoStatus[0] + xoStatus[1] + xoStatus[2]
                }

                1 -> {
                    lineString = xoStatus[3] + xoStatus[4] + xoStatus[5]
                }

                2 -> {
                    lineString = xoStatus[6] + xoStatus[7] + xoStatus[8]
                }

                3 -> {
                    lineString = xoStatus[0] + xoStatus[3] + xoStatus[6]
                }

                4 -> {
                    lineString = xoStatus[1] + xoStatus[4] + xoStatus[7]
                }

                5 -> {
                    lineString = xoStatus[2] + xoStatus[5] + xoStatus[8]
                }

                6 -> {
                    lineString = xoStatus[0] + xoStatus[4] + xoStatus[8]
                }

                7 -> {
                    lineString = xoStatus[2] + xoStatus[4] + xoStatus[6]
                }
            }


            if (lineString == "xxx") {
                statusWinner = "x"
                break
            } else if (lineString == "ooo") {
                statusWinner = "o"
                break
            } else {
                statusWinner = "draw"
            }
        }
        println("StatusWinnerLAST BEYB $statusWinner")
        println("Count empty beyb $countOfEmpty")
        return statusWinner
    }

    fun oncRestart(view: View) {
        restart()
    }


}