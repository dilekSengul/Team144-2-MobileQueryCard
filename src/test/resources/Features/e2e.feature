Feature: E2E

  @e2e
  Scenario: E2E

    # Özge hoca team 2 ekibinin çok çalıştığını ve aylardır büyük emek harcadığını görür
      # ve bu sprint sonunda kendilerine birer hediye almak ister querycard sitesine girer kullanıcı girişi yapar
        # ve 11 öğrenciye 11 adet saat seçer sepete ekler. (Herkese aynı saati seçer ki kimsenin gönlü kalmasın) kart bilgilerini girer
          # alışverişi tamamlar. Biraz düşününce bunun kendisine biraz pahalıya patladığını düşünür ve tüm siparişi iptal eder.
            # Anasayfada popular brandstan us Polo markayı seçip oradan 11 adet beyaz çorap sepete ekler alışveriş bilgilerini girer ve alışverişi tamamlar.

    Given User makes driver adjustments
    # Kullanıcı emulatör için gerekli ayarlamaları yapıp kullanıma hazır hale getirir.
    Given User clicks the button with description "Profile"
    # Kullanıcı querycart uygulamasının alt bar'ında bulunan "Profile" butonuna basar.
    When User clicks the button with description "Sign In"
    # Kullanıcı "Sign In" butonuna basarak giriş yapma ekranına yönlendirilir.
    Then As a user muss be "phoneNumber" phone and "password" password Login
    # Kullanıcı giriş yapma ekranında bulunan phoneTextbox'a daha önce siteye kayıt olduğu telefon numarasını ve passwordTextbox'a şifresini girer.
    And current products should be listed under "Most Popular" by swiping 1 times
    # Kullanıcı ana sayfada pöpüler olan ürünler üzerinde kaydırma işlemini yapar
    And User clicks on the watch product
    # Kullanıcı popüler ürünler içerisinde saat seçer
    And User waits 3 seconds
    # Kullanıcı aradığı ürünün gelmesi için 3 saniye bekler (internet problemi)
    And User swipe to screen coordinates 643, 2446, 649, 1378
    # Kullanıcı sepete ekleme işlemini yapmak için kaydırma işlemini yapar.
    When User clicks the button with description "Brown"
    # Kullanıcı verilen renk seçeneklerinden biri olan kahverengi seçer
    And User presses the plus button
    # Ardından 11 adet olmak üzere sipariş miktarını arttırır
    When User clicks the button with description "Add To Cart"
    # Kullanıcı Add To Cart butonuna basarak sepete ekleme işlemini gerçekleştirir
    And User clicks tap coordinates 1195, 2699
    # Kullanıcı ürünü sepete ekledikten sonra sepet butonuna basarak sepet sayfasına erişir
    And QueryCart customer clicks Prooceed to Checkout button
    # Kullanıcı ödeme işlemine devam etmek için Prooceed to Checkout butonuna basar
    And User clicks tap coordinates 695, 988
    # Kullanıcı ürün teslim yeri için adres seçer
    And QueryCart customer makes the swipe operation for Save & Pay button
    # Kullanıcı Save & Pay butonu için kaydırma işlemi yapar
    And User clicks the button with description "Save & Pay"
    # Kullanıcı Save & Pay butonuna basarak ödemede bir sonraki adıma geçer
    And User clicks the button with description "Cash On Delivery"
    # Kullanıcı Cash On Delivery ödeme yöntemini seçerek ödemeyi kapıda yapacağını belirtir
    And User clicks the button with description "Confirm Order"
    # Kullanıcı Confirm Order butonuna basarak ödemeyi sonlandırır
    And User waits 15 seconds
    # Kullanıcı ödemenin gerçekleşmesi için bekler (Onay işlemi için gereken miktar 10 saniye yeterli)
    When User clicks the button with description "Go to order details"
    # Kullanıcı daha önceki siparişlerini görmek için Go to order details butonuna basar
    And User waits 2 seconds
    # Kullanıcı sayfanın yüklenmesini bekler
    Then The "Order History" title should be displayed
    # Kullanıcı doğru sayfaya ulaştığını sayfa başlığıyla doğrular
    And User clicks on the first order in the list
    # Kullanıcı en son sipariş verilen ürünün detaylarına bakmak için sayfada bulunan ilk faturaya tıklar
    And User waits 3 seconds
    # Kullanıcı siparıiş süreci, ürün bilgisi, toplam tutar (vs.) bilgilerini görüntülemek için 3 saniye bekler
    And User scroll down the screen
    # Kullanıcı sayfanın en aşağısına kaydırır
    Then User clicks the button with description "Cancel Order"
    # Kullanıcı toplam fiyatın bütçesine uygun olmadığı için siparişi iptal etmeye karar verir
    Then User should see an "Order Canceled Successfully!" message on the popup page.
    # Kullanıcı Cancel Order tuşuna bastıktan sonra başarıyla iptal edildiğini pop-up mesajıyla doğrular
    And Driver turns off
    # Kullanıcı mobil uygulamayı kapatıp yoluna devam eder


  # Bu testin amacı Bu testin amacı, son kullanıcı perspektifinden uçtan uca (E2E) bir alışveriş sürecinin doğru bir şekilde işleyip işlemediğini doğrulamaktır.