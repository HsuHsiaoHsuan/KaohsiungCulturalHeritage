package funnybrain.kaohsiungculturalheritage.data.source

interface DataSource {
    interface GetDataCallback {
        fun onDataLoaded()

        fun onDataNotAvailable()
    }
}