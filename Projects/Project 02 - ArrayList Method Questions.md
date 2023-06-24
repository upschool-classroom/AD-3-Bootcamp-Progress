
# Project 2 : ArrayList Method Questions

Methodları tekrar etmek adına aşağıdaki 5 soruyu ilk ödevde olduğu gibi main fonksiyonu içinde 5 ayrı file açarak tek tek çözünüz

## Sorular:

### Soru 1
- 5 isim içeren bir ArrayList oluşturun.
- Kullanıcıdan, aralarına virgül koyarak 3 isim girmesini isteyin.
- Bu girilen 3 isimlik String’i aradaki virgülleri kullanarak parçalayın ve listeye dönüştürün
- Bu listenin bol olup olmadığını kontrol edin.
- Boş değilse oluşturduğunuz 5 isimlik listeye ekleyin ve son halini konsola yazdırın.

### Soru 2
```kotlin
val names = arrayListOf("Sinem", "Ali", "Hümeyra", "Cem", "Gizem")
```
- Yukarıdaki isimler listesini kullanarak önce harflere göre listeyi sıralayın.
- Kullanıcıdan, 1 adet isim isteyin.
- Bu isim names listesinde var mı yok mu kontrol edin.
- Varsa bu ismi listede arayın, tüm harfleri büyük ve ters çevrilmiş şekilde konsola yazdırın.

### Soru 3
```kotlin
data class Student(val name: String, val age: Int, val school: String)  
  
val students = arrayListOf(  
    Student("Ahmet", 20, "Üniversite A"),  
    Student("Ayşe", 27, "Üniversite B"),  
    Student("Mehmet", 22, "Üniversite C"),  
    Student("Fatma", 28, "Üniversite A"),  
    Student("Ali", 29, "Üniversite B"),  
    Student("Feyza", 24, "Üniversite A"),  
    Student("Berkay", 22, "Üniversite B"),  
    Student("Caner", 26, "Üniversite A")  
)
```
- İlk olarak en büyük ve en küçük yaşa sahip olan öğrencinin ismini ve kaçıncı indexte olduğunu konsola yazdırın.
- Listede school değeri Üniversite A olanları filtreleyin.
- Filtreleme işleminden dönen listeyi yaşları 25’ten büyükler ve küçükler olarak alt alta konsola yazdırın.

### Soru 4
```kotlin
data class CoinResponse(val name: String, val coinId: String, val hashingAlgorithm: String, val description: String, val image: String, val currentPrice: Float, val priceChangePercentage24h: Float)

data class CoinUI(val name: String, val coinId: String, val description: String, val image: String)

val coinList = arrayListOf(
    CoinResponse(
        name = "Bitcoin",
        coinId = "BTC",
        hashingAlgorithm = "SHA-256",
        description = "Bitcoin is a decentralized digital currency, without a central bank or single administrator.",
        image = "https://example.com/bitcoin.png",
        currentPrice = 34789.21,
        priceChangePercentage24h = -2.34
    ),
    CoinResponse(
        name = "Ethereum",
        coinId = "ETH",
        hashingAlgorithm = "Ethash",
        description = "Ethereum is an open-source, blockchain-based platform that enables developers to build and deploy smart contracts.",
        image = "https://example.com/ethereum.png",
        currentPrice = 2110.45,
        priceChangePercentage24h = 0.78
    ),
    CoinResponse(
        name = "Litecoin",
        coinId = "LTC",
        hashingAlgorithm = "Scrypt",
        description = "Litecoin is a peer-to-peer cryptocurrency that enables instant, near-zero cost payments to anyone in the world.",
        image = "https://example.com/litecoin.png",
        currentPrice = 129.57,
        priceChangePercentage24h = -1.12
    ),
    CoinResponse(
        name = "Ripple",
        coinId = "XRP",
        hashingAlgorithm = null,
        description = "Ripple is a digital payment protocol and cryptocurrency that is designed to facilitate fast, low-cost international money transfers.",
        image = "https://example.com/ripple.png",
        currentPrice = 0.5483,
        priceChangePercentage24h = 1.45
    )
)
```
- Yukarida tipi CoinResponse olan bir ArrayList var.
- Bu ArrayList’i tipi CoinUI olan bir listeye dönüştürün ve konsola yazdırın.

### Soru 5
```kotlin
data class Workers(val name: String, val salary: Double)

val workers = arrayListOf(
    Workers("Ahmet Yılmaz", 15000.0),
    Workers("Ayşe Kaya", 32000.0),
    Workers("Mehmet Demir", 29000.0),
    Workers("Fatma Şahin", 18500.0)
)
```
- Yukarıdaki işçiler listesini kullanarak her çalışana %35 zam yapın.
- Listeyi karıştırıp maaş değerine göre küçükten büyüğe sıralayın.
- En yüksek ve en düşük maaş alanları konsola yazdırın.
- Maaş ortalamasını hesaplayıp konsola yazdırın.

## -> Ödev Teslim Tarihi: 7 Temmuz Cuma 20.00
