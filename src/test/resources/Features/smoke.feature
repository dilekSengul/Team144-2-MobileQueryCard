Feature: Smoke Test, temel işlevlerin doğru çalışıp çalışmadığını hızlıca kontrol etmek için yapılan bir testtir.

  @smoke
  Scenario: Kritik sorunları erken tespit etmek için kullanılır.

    Given User makes driver adjustments
    # Kullanıcı emulatör için gerekli ayarlamaları yapıp kullanıma hazır hale getirir.
    When User confirms to be on the homepage
    # Kullanıcı uygulamanın doğru bir şekilde açıldığını doğrulamak için site üzerindeki logoyu doğrular.
    Then User clicks the button with description "Profile"
    # Kullanıcı querycart uygulamasının alt bar'ında bulunan "Profile" butonuna basar.
    And User clicks the button with description "Sign In"
    # Kullanıcı "Sign In" butonuna basarak giriş yapma ekranına yönlendirilir.
    And As a user muss be "phoneNumber" phone and "password" password Login
    # Kullanıcı giriş yapma ekranında bulunan phoneTextbox'a daha önce siteye kayıt olduğu telefon numarasını ve passwordTextbox'a şifresini girer.
    When User confirms to be on the homepage
    # Kullanıcı uygulamanın doğru bir şekilde açıldığını doğrulamak için site üzerindeki logoyu doğrular.
    And User presses the magnifying glass button to make a search
    # Ardından kullanıcı arama yapabilmek için home page'deki üst bar'da bulunan büyteç butonuna basar.
    And User types "Flower Print" in searchTextBox
    # Kullanıcı searchTextBox'a ürün adını girerek hem textbox'ın çalıştığını kontrol eder hemde aradığı ürünün bulunmasında yardımcı olur.
    And User waits 3 seconds
    # Kullanıcı aradığı ürünün gelmesi için 3 saniye bekler (internet problemi)
    And User clicks the button with itemName "Flower Print Foil T-shirt" and "0 (0  Reviews)" and "$65.00" added WishList
    # Kullanıcı arama sonucunda çıkan ürünü wiss list (favori) ekler bu şekilde sitede normal bir kullanıcı bile sevdiği ürünü kaydede bilir.
    And User clicks the backArrow button
    # Kullanıcı ürünü favorilere ekledikten sonra geri tuşuna basarak arama sayfasına yeniden yönlendirilir
    And User clicks the backArrow button
    # Kullanıcı tekrardan geri tuşuna basarak ana sayfaya yönlendirilir
    And User clicks the button with description "Wishlist"
    # Kullanıcı ürünü wish liste eklemesinden sonra querycart uygulamasının alt bar'ında bulunan "Wishlist" butona tıklar
    And User waits 5 seconds
    # Kullanıcı aradığı ürünün gelmesi için 5 saniye bekler (internet problemi)
    And User selects the Flower Print Foil Tshirt product on the Home page
    # Kullanıcı gösterilen favori ürünlerden Flower Print Foil T-shirt seçerek ürün sayfasına ulaşır.
    And User selects "L" as size
    # Kullanıcı ona uygun olan bedeni seçer
    And User presses the Add To Cart button
    # Kullanıcı sepete ekleme işlemini yapmak için kaydırma işlemini yapar ve daha sonra Add To Cart butonuna basar
    And User clicks tap coordinates 1195, 2699
    # Kullanıcı ürünü sepete ekledikten sonra sepet butonuna basarak sepet sayfasına erişir
    And User waits 3 seconds
    # Kullanıcı aradığı ürünün gelmesi için 3 saniye bekler (internet problemi)
    And The user verifies that there are items in the shopping basket
    # Kullanıcı sepette ürün olduğunu doğrular bu sayede sepet fonksiyonun düzgün bir şekilde çalışıp çalışmadığını doğrular


  # BU testin amacı sitenin temel işlevlerinin doğru bir şekilde çalışmasını sağlamaktır, Asıl en önemlisi işlevlerden oluşan kusurun tespit edilmesidir