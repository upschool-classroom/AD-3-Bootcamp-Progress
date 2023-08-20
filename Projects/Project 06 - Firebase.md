
# Project 6 : Firebase - Budget App

## Screens

### Sign In
- Firebase auth kullanılarak e-mail ve şifre yöntemini kullanarak kullanıcının giriş yapmasını sağlayın.

### Sign Up
- Firebase auth kullanılarak e-mail ve şifre yöntemini kullanarak kullanıcının üye olmasını sağlayın.

### Summary
- Ekranın üstünde profil resmi ve yanında kullanıcının ismi yazacak. En sağda ise çıkış yapma görseli olacak. Bastığımızda firebase authtan sign out olmalıyız ve Sign In ekranına gitmeliyiz.
- Tüm income_expense collectionı çekilip RecyclerView'da listelenecek. Gelir ve gider olmasına göre birbirinden ayırt edecek bir tasarım uygulayın.
  <br> Örnek:
  <br> ![Example](https://github.com/upschool-classroom/AD-3-Bootcamp-Progress/assets/29903779/bf991d45-0e30-4abb-bb0b-2d7140621bdb)
- Bir itema bastığımda Add or Edit sayfası açılacak ve tıklanan item oraya args ile gönderilecek.
- Ekranın en altında recyclerview altında bir card oluşturun ve tüm gelir giderleri toplayıp totali oraya - de ise kırmızı olarak + da ise yeşil olarak yazdırın.
- Toolbar ile recyclerview arasında bir Add butonu olmalı ve bastığımızda Add or Edit sayfası açılacak ve veri gönderilmeyecek.

### Income
- Buraya income_expense collectionı altındaki verilerden income olanlar çağırılacak ve listelenecek.
- Bir itema bastığımda Add or Edit sayfası açılacak ve tıklanan item oraya args ile gönderilecek.
- Tasarım olarak summary ekranındakine benzer bir yapı kullanabilirsiniz size kalmış.
- En altta summary ekranındaki gibi totali gösterelim.

### Expense
- Buraya income_expense collectionı altındaki verilerden expense olanlar çağırılacak ve listelenecek.
- Bir itema bastığımda Add or Edit sayfası açılacak ve tıklanan item oraya args ile gönderilecek.
- Tasarım olarak summary ekranındakine benzer bir yapı kullanabilirsiniz size kalmış.
- En altta summary ekranındaki gibi totali gösterelim.

### Add or Edit (BottomSheetDialogFragment)
- Bu sayfaya model gönderilirse edit olacak şekilde açılacak dersteki gibi. Edit butonuna bastığımızda kaydedip başarılıysa BottomSheet'i kapattıracağız.
- Model gönderilmezse ekleme yapacağımız şekilde boş açılacak. Add butonuna bastığımızda ekleyip başarılıysa BottomSheet'i kapattıracağız.

## Notlar
- Bottom Navigation olacak. Summary - Income - Expense sayfaları burada olacak.
- Kullanıcı Sign Up ve Sign In ekranlarındayken Bottom Navigation'ı görmemeli.
- Kullanıcı giriş yaptıysa sonraki girişlerde Sign In ve Sign Up'ı görmemeli
- Veriler "income_expense" collection'ı altında kaydedilecek.
- income veya expense farkını modelinizdeki bir boolean ile kontrol kaydedin ve kontrol edin.
- En az 4 değişken olmalı -> docId: String, title: String, price: Double, incomeExpenseType: Boolean (Ekleme yapabilirsiniz 🙂)
- En az 3 harcama ve 3 gelir tipi bulunmalı. Bunlar seçtirilmeli. (Icon da kullanabilirsiniz ve tasarım olarak da güzel durur. Icon'u firebase'de tutmak zorunda değilsiniz. Dönen tipe göre drawable içinden if komutuyla çağırıp ImageView'a basabilirsiniz.)
- Veriler 3 sayfada da canlı dinlenecek.

## -> Teslim Tarihi: 27 Ağustos Pazar 20.00
