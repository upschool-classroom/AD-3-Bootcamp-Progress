
# Project 5 : Retrofit - Books App

## Servis Details

### - Base Url -> https://api.canerture.com/books/

### - All Books
Endpoint: all_books.php <br>
Method: GET <br>
Parameters: empty

#### Sample Response
```kotlin
{
  "books": [
    {
      "id": 1,
      "name": "The Great Gatsby",
      "author": "F. Scott Fitzgerald",
      "publisher": "Scribner",
      "price": 12.99,
      "image_url": "https://i.dr.com.tr/cache/500x400-0/originals/0002042036001-1.jpg",
      "is_best_seller": false
    }
  ],
  "success": 1,
  "message": "Successful"
}
```

### - Book Detail
Endpoint: get_book_detail.php <br>
Method: GET <br>
Parameters: @Query("id")

#### Sample Response
```kotlin
{
  "book": {
    "id": 1,
    "name": "The Great Gatsby",
    "author": "F. Scott Fitzgerald",
    "publisher": "Scribner",
    "price": 12.99,
    "image_url": "https://i.dr.com.tr/cache/500x400-0/originals/0002042036001-1.jpg",
    "is_best_seller": false
  },
  "success": 1,
  "message": "Successful"
}
```

## Screens

### Main
- Tüm kitapları çekip kitabın görselini, adını ve fiyatını RecyclerView içinde listeleyin.
- "is_best_seller" değişkenini kontrol edip kitabın en çok satan olduğunu belli eden bir badge gösterin item tasarımda. (Örn: Sol üstte yuvarlak ufak bir TOP yazılı görsel)
- Bir kitaba tıklandığında detaya gidilecek ve id gönderilecek.

### Detail
- Buraya gelen id'yi kullanarak detay servisine istek atın.
- Gelen tüm veriyi detay tasarımında kullanın.

## -> Teslim Tarihi: 20 Ağustos Pazar 12.00
