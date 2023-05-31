# Android Testing Uygulaması

Bu, Android Testing konseptlerini pratik etmek amacıyla geliştirilmiş bir uygulamadır. Uygulama, https://pixabay.com adresinin API'sini kullanır ve MVVM (Model-View-ViewModel) yapısına uygun olarak geliştirilmiştir.

## Kullanılan Teknolojiler

- Retrofit & Coroutine: HTTP isteklerini yapmak ve verileri almak için kullanılan bir kütüphane ve asenkron işlemleri yönetmek için Coroutine kullanılır.
- Room Database: Uygulama verilerini yerel olarak depolamak için kullanılan bir SQLite nesne ilişkisel eşleme (ORM) kütüphanesidir.
- MVVM (Model-View-ViewModel): Uygulama mimarisi olarak MVVM kullanılır. Bu mimaride veri kaynağı (Model), kullanıcı arayüzü (View) ve iş mantığı (ViewModel) ayrı ayrı ele alınır.
- Fragment Navigation Framework: Uygulama içindeki gezinmeyi yönetmek için kullanılan bir kütüphane.
- Glide: İnternetten resimleri yüklemek ve görüntülemek için kullanılan bir resim işleme kütüphanesidir.
- Test Framework: Uygulama testleri için kullanılan test framework'leri şunlardır:
  - Mockito: Mock nesneleri oluşturmak ve testleri daha kolay yapmak için kullanılan bir Java test framework'üdür.
  - Espresso: Android uygulamaları için UI testlerini yazmak ve çalıştırmak için kullanılan bir test framework'üdür.

## Kurulum

1. Bu depoyu yerel makinenize klonlayın.
2. Android Studio'yu açın ve projeyi içe aktarın.
3. Gerekli bağımlılıkları indirmek için Gradle Sync'i çalıştırın.

## Kullanım

1. Uygulamayı çalıştırın.
2. Uygulamayı kullanarak çeşitli test senaryolarını deneyin.
3. Uygulama içinde yer alan farklı ekranlara gezinin ve verilerin doğru şekilde görüntülendiğini doğrulayın.
4. Test senaryoları için gerekli adımları takip edin ve sonuçları analiz edin.

## Örnek Kullanım Kodu

Uygulama içinde Retrofit ile API istekleri yapılır ve veriler Room Database'e kaydedilir. Örnek kullanım kodu aşağıdaki gibi olabilir:

```kotlin
// API isteği yapmak için Retrofit service'ini oluşturun
val retrofit = Retrofit.Builder()
    .baseUrl("https://pixabay.com/api/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val service = retrofit.create(ApiService::class.java)

// Resimleri almak için bir istek yapın
val response = service.getImages()

// İstek sonucunu işleyin ve verileri Room Database'e kaydedin
response.enqueue(object : Callback<ImageResponse> {
    override fun onResponse(call: Call<ImageResponse>, response: Response<ImageResponse>) {
        if (response.isSuccessful) {
            val images = response.body()?.results
            // Verileri Room Database'e kaydedin
            // ...
        }
    }

    override fun onFailure(call: Call<ImageResponse>, t: Throwable) {
        // Hata durumunda işlemleri ele alın
        // ...
    }
})
```
## Testler
Uygulamada çeşitli test senaryolarını kapsayan testler yer alır. Bu testler, Mockito ve Espresso test framework'leri kullanılarak yazılmıştır. Testlerin başarılı bir şekilde çalışması için aşağıdaki adımları takip edin:

## Görseller
![Görsel 1](https://github.com/fatihCetiner/AndroidTesting/assets/53433157/3e1474c4-e7af-4752-8988-4b8142553c41)

Kayıt Edilen Veri sağa veya sola kaydırarak silebilirsiniz.

![Görsel 2](https://github.com/fatihCetiner/AndroidTesting/assets/53433157/88d569c7-3880-469f-9c26-193b6dbdde64)

Kyıt Edilen veri anasayfada alt alta bilgileri ile listelenir

![Görsel 3](https://github.com/fatihCetiner/AndroidTesting/assets/53433157/836f9176-ff3e-4abd-89c8-8a7e34bbef17)

Resim seçildikden sonra bu sayfada kalan değerleri girebilirsiniz

![Görsel 4](https://github.com/fatihCetiner/AndroidTesting/assets/53433157/6729a17f-d52f-4468-b884-6eefbd285bd4)

Arama kutusundan istediğiniz resmi aratarak çıkan sonuçlardan birini seçebilirsiniz

1. Test senaryolarını çalıştırmadan önce emulatorü veya fiziksel cihazı başlatın.
2. Testlerin bulunduğu test klasöründe sağ tıklayın ve "Run Tests" seçeneğini seçin.
3. Testlerin başarılı bir şekilde çalıştığını gözlemleyin ve sonuçları analiz edin.
## Katkıda Bulunma
Eğer bu projeye katkıda bulunmak isterseniz, lütfen CONTRIBUTING.md dosyasını inceleyin ve pull request göndermeden önce geliştirme adımlarını takip edin.

## Teşekkürler
Bu uygulama, Pixabay API'si ve kullanılan kütüphaneler sayesinde oluşturulmuştur. Proje için geliştiricilere teşekkür ederiz.
