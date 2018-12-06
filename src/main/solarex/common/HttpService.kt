package common

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Url

/**
 * Created by houruhou on 2018/12/6.
 * Desc:
 */
interface Service {
    @GET
    fun getLogo(@Url url: String): Call<ResponseBody>
}

object HttpService {
    val service by lazy {
        val retrofit = Retrofit.Builder().build()

        retrofit.create(Service::class.java)
    }
}