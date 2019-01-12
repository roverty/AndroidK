class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(createFrameL())
    }

    private fun createFrameL() : FrameLayout {
        val tv1 = TextView(this)
        tv1.text = "hello"
        tv1.textSize = 40f
        tv1.setTextColor(Color.BLACK)

        val tv2 = TextView(this)
        tv2.layoutParams = ActionBar.LayoutParams(
            ActionBar.LayoutParams.FILL_PARENT,
            ActionBar.LayoutParams.WRAP_CONTENT,
            Gravity.BOTTOM
        )
        tv2.textSize = 50f
        tv2.gravity = Gravity.RIGHT
        tv2.text = "bye"
        tv2.setTextColor(Color.WHITE)

        val iv1 = ImageView(this)
        iv1.setImageResource(R.drawable.pinkfloyd)
        iv1.layoutParams =
                ActionBar.LayoutParams(ActionBar.LayoutParams.FILL_PARENT, ActionBar.LayoutParams.FILL_PARENT)
        iv1.scaleType = ImageView.ScaleType.MATRIX

        val fl = FrameLayout(this)
        fl.layoutParams = ActionBar.LayoutParams(ActionBar.LayoutParams.FILL_PARENT, ActionBar.LayoutParams.FILL_PARENT)
        fl.addView(iv1)
        fl.addView(tv1)
        fl.addView(tv2)
        return fl
    }
}