package funnybrain.kaohsiungculturalheritage.data.model;

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DataItem(
        @SerializedName("Heritage_INDEX")
        @Expose
        val index: String?,

        @SerializedName("Heritage_title")
        @Expose
        val title: String?,

        @SerializedName("Heritage_class")
        @Expose
        val type: String?,

        @SerializedName("Heritage_desc")
        @Expose
        val desc: String?,

        @SerializedName("Heritage_travel")
        @Expose
        val memo: String?,

        @SerializedName("Heritage_Image")
        @Expose
        val image: List<String> = ArrayList()) : Parcelable

/*
{
    "Heritage_INDEX": "5067ee0c-b9ce-44b9-b6fd-c447dd872676",
    "Heritage_title": "獻馬圖",
    "Heritage_class": "古物",
    "Heritage_desc": "種類：藝術作品\r\n指定/登錄別：一般古物(地方登錄)\r\n區域：鼓山區\r\n名稱：獻馬圖\r\n創建年代：\r\n公告文號：高市府四維文博字第1000140520號\r\n公告日期：2011/12/20\r\n數量：1\r\n地址：高雄市鼓山區美術館路80號\r\n建造者：\r\n保管單位：\r\n登錄理由：林玉山（1907-2004）為台灣著名前輩畫家。19歲負笈日本，留學東京川端畫學校，開始接受完整的專業美術教育。一年後暑假返台期間，參加第一回台灣美術展覽會即獲入選，並與郭雪湖、陳進同被譽為「台展三少年」，自此崛起畫壇，壯年時期已是嘉義畫壇的領導人物。林玉山作育英才無數，為人謙遜，淡泊名利，其作品以膠彩畫及水墨畫著稱。\r\n「獻馬圖」係作者林玉山1999年捐贈予高美館的一件屏風作品。該作原完成於1943年，但因二二八事件的關係塵封近60年未曾露面，直到1999年林玉山先生將其捐贈高美館始重見光明，並經修復、重新裝裱、補畫後，於2000年首次公開發表。原作部份，創作時代背景為日治末期，某日作者見十餘名軍伕牽著民間徵調之馬匹，馬背上綁著日本國旗，名之為「獻馬」。作者返家後，心有所感創作成四屏聯作「獻馬圖」，此作可謂真實記錄戰爭末期徵集物資的實況。二二八事件發生後風聲鶴唳，作者為免波及而將原作上的日本國旗改畫為中華民國國旗後藏匿；原作之右邊兩屏因蟲蛀及潮濕而損壞，於1999年捐贈予高美館時，作者林玉山憑記憶重畫，並為重現歷史，恢復原始畫作上日本國旗的面貌。本作品為作者唯一以馬為主題之作，作者畫馬行筆順暢、線條節奏分明，可見作者寫生功力之非凡。此作以「屏風」形式表現，為作者早期作品重要形式之一，亦為日治時期台籍膠彩畫家常用的作品表現形式。在歷史意義上，此作品更反映出日治末期及戰後二二八事件時之特殊時代氛圍，係林玉山該時期重要代表作之ㄧ。本作品無論就林玉山或台灣美術與歷史而言，均顯意義重大，可彰顯一定之時代特色、技術及流派，並在藝術及歷史上具有特殊之價值。\r\n",
    "Heritage_travel": ".法令依據\r\n1.本作品反映出日治末期及戰後二二八事件時之特殊時代氛圍具有歷史意義，符合「古物分級登錄指定及廢止審查辦法」第2條第1項登錄基準。\r\n2.本作品以「屏風」形式表現，具有一定時代特色及技術，符合「古物分級登錄指定及廢止審查辦法」第2條第3項登錄基準。\r\n3.本作品具有藝術造詣，符合「古物分級登錄指定及廢止審查辦法」第2條第4項登錄基準。\r\n4.綜上所述，本件作品具歷史、文化、藝術價值，符合「古物分級登錄指定及廢止審查辦法」第2條第6項登錄基準。\r\n.介紹\r\n.技法流派\r\n.材質\r\n.形狀\r\n.尺寸\r\n",
    "Heritage_Image": [
      "http://opendata.khcc.gov.tw/upload/Heritage/20120727150319446.jpg"
    ]
  },
 */