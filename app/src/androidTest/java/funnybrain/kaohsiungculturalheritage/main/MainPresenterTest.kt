package funnybrain.kaohsiungculturalheritage.main

import okhttp3.mockwebserver.MockWebServer
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MainPresenterTest {

    companion object {
        @BeforeAll
        @JvmStatic
        fun beforeAllTest() {
            println("Before all tests")
        }

        @AfterAll
        fun afterAllTest() {
            println("After all tests")
        }
    }


    @Test
    fun getData() {
        val server = MockWebServer()
        var req1 = server.takeRequest()
        assertEquals("/v1/hello", req1.path)

        server.start()



    }
}

/*

https://github.com/square/okhttp/tree/master/mockwebserver

https://github.com/square/retrofit/blob/master/retrofit-mock/src/main/java/retrofit2/mock/MockRetrofit.java

https://questdot.com/android-retrofit-mock-response-tutorial/

https://riggaroo.co.za/retrofit-2-mocking-http-responses/

https://stackoverflow.com/questions/17544751/square-retrofit-server-mock-for-testing

https://zhuanlan.zhihu.com/p/21364346

MockK:
https://blog.kotlin-academy.com/mocking-is-not-rocket-science-mockk-advanced-features-42277e5983b5

https://www.baeldung.com/kotlin-mockk

https://mockk.io

https://medium.com/joe-tsai/mockk-一款強大的-kotlin-mocking-library-part-1-4-39a85e42b8

https://developerlife.com/2018/10/21/kotlin-testing-setup/

JUnit 5:
https://www.petrikainulainen.net/junit-5-the-ultimate-resource/

https://www.baeldung.com/junit-5-kotlin


 */