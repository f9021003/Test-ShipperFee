import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CartTest {
    private val cart = Cart()
    private val blackCat = "black cat"
    private val hsinchu = "hsinchu"
    private val postOffice = "post office"

    @Test
    fun `black cat with light weight`() {
        val shippingFee = cart.shippingFee(blackCat, 30.0, 20.0, 10.0, 5.0)
        feeShouldBe(150.0, shippingFee)
    }

    @Test
    fun `black cat with heavy weight`() {
        val shippingFee = cart.shippingFee(blackCat, 30.0, 20.0, 10.0, 50.0)
        feeShouldBe(500.0, shippingFee)
    }

    @Test
    fun `hshinchu with small size`() {
        val shippingFee = cart.shippingFee(hsinchu, 30.0, 20.0, 10.0, 50.0)
        feeShouldBe(144.0, shippingFee)
    }

    @Test
    fun `hshinchu with huge size`() {
        val shippingFee = cart.shippingFee(hsinchu, 100.0, 20.0, 10.0, 50.0)
        feeShouldBe(480.0, shippingFee)
    }

    @Test
    fun `post office by weight`() {
        val shippingFee = cart.shippingFee(postOffice, 100.0, 20.0, 10.0, 3.0)
        feeShouldBe(110.0, shippingFee)
    }

    @Test
    fun `post office by size`() {
        val shippingFee = cart.shippingFee(postOffice, 100.0, 20.0, 10.0, 300.0)
        feeShouldBe(440.0, shippingFee)
    }

    private fun feeShouldBe(expect: Double, shippingFee: Double) = assertEquals(expect, shippingFee)
}