package com.eric.notebook.timeanddate

import com.eric.notebook.R
import com.eric.notebook.copymodel.DataClass
import com.eric.notebook.title.TitleFromDescription
import org.junit.Assert.assertEquals
import org.junit.Test

class UnitTest {

    @Test
    fun test_time() {
        val timeNow = TimeRightNow.TimeRightNowImpl().timeRightNow()
        assertEquals("18:59", timeNow)
    }

    @Test
    fun test_data() {
        val data = DataToday.DataTodayImpl().dataToday()
        assertEquals("4 Января", data)

    }

    @Test
    fun test_ui() {
        val editTextDescription = "hello world and my friends 1234 56"
        val charSentence = editTextDescription.toCharArray()
        var title = ""

        for (i in 0..30) {
            title += charSentence[i].toString()
        }
        assertEquals("hello world and my friends 1234", title)
    }

    @Test
    fun test_color() {
        val color = R.color.dark_red

        assertEquals("#571818", color)
    }

    @Test
    fun test_title_from_description() {

        val title = TitleFromDescription.TitleImpl()
            .time("hello world and my friends 1234 dsgljdslgjdlksjglkdsjfgkjsdfjfg")

        assertEquals("hello world and my friends 1234", title)
    }

    @Test
    fun test_copy_model() {

        var model1 = DataClass(1,"pov")
        var actual = model1.copy(title = "lol")
        var expected = DataClass(1, "lol")


        assertEquals(expected, actual)
    }
}