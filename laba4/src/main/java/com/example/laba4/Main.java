package com.example.laba4;

import com.example.laba4.model.Picture;
import com.example.laba4.repository.PicRep;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Main implements CommandLineRunner {

    private final PicRep picRepository;

    public Main(PicRep picRepository) {
        this.picRepository = picRepository;
    }
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    public Picture saveOrUpdatePicture(String name, String author, String imageUrl) {
        List<Picture> existing = picRepository.findByName(name);

        Picture picture;
        if (existing.isEmpty()) {
            // Якщо такої картини немає — створюємо нову
            picture = new Picture(name, author, imageUrl);
        } else {
            // Якщо є — оновлюємо
            picture = existing.get(0);
            picture.setAuthor(author);
            picture.setImage_url(imageUrl);
        }
        // Зберігаємо у базу (нову або оновлену)
        return picRepository.save(picture);
    }

    @Override
        public void run(String... args) {
        /*String pictureName = "Зоряна ніч";
        List<Picture> existing = picRepository.findByName(pictureName);

        Picture picture;
        if(existing.isEmpty()) {
            picture = new Picture(pictureName, "Ван Гог", "https://cultmall.com.ua/image/cache/catalog/tn706-750x750.jpg");
        } else {
            picture = existing.get(0);
            picture.setAuthor("Ван Гог");
            picture.setImage_url("https://cultmall.com.ua/image/cache/catalog/tn706-750x750.jpg");
        }
        picRepository.save(picture);
        System.out.println("Картина збережена: " + picture);*/
        Picture savedPicture = saveOrUpdatePicture(
                "Зоряна ніч",
                "Ван Гог",
                "https://cultmall.com.ua/image/cache/catalog/tn706-750x750.jpg"
        );
        System.out.println("Картина збережена: " + savedPicture);
        Picture savedPicture2 = saveOrUpdatePicture(
                "Дівчина з перловою сережкою",
                "Ян Вермер",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/7/77/%D0%94%D0%B5%D0%B2%D1%83%D1%88%D0%BA%D0%B0_%D1%81_%D0%B6%D0%B5%D0%BC%D1%87%D1%83%D0%B6%D0%BD%D0%BE%D0%B9_%D1%81%D0%B5%D1%80%D1%91%D0%B6%D0%BA%D0%BE%D0%B9.jpg/500px-%D0%94%D0%B5%D0%B2%D1%83%D1%88%D0%BA%D0%B0_%D1%81_%D0%B6%D0%B5%D0%BC%D1%87%D1%83%D0%B6%D0%BD%D0%BE%D0%B9_%D1%81%D0%B5%D1%80%D1%91%D0%B6%D0%BA%D0%BE%D0%B9.jpg"
        );
        System.out.println("Картина збережена: " + savedPicture2);
        Picture savedPicture3 = saveOrUpdatePicture(
                "Постійність пам'яті",
                "Сальвадор Далі",
                "https://upload.wikimedia.org/wikipedia/uk/3/3e/%D0%9F%D0%BE%D1%81%D1%82%D1%96%D0%B9%D0%BD%D1%96%D1%81%D1%82%D1%8C_%D0%BF%D0%B0%D0%BC%27%D1%8F%D1%82%D1%96.jpg"
        );
        System.out.println("Картина збережена: " + savedPicture2);
    }
}