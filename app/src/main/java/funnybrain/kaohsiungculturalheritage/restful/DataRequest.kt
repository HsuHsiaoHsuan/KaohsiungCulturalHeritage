package funnybrain.kaohsiungculturalheritage.restful

import com.orhanobut.logger.Logger
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

object DataRequest {
    private val onErrorComsumer = Consumer<Throwable> { t: Throwable ->
        Logger.e(t.message.toString())
        t.printStackTrace()
    }

    fun <T> performAsyncRequest(observable: Observable<T>, onConsumer: Consumer<in T>, onError: Consumer<Throwable> = onErrorComsumer): Disposable {
        return observable
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(onConsumer, onError)
    }
}