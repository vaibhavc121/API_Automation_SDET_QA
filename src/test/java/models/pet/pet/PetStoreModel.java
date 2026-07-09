package models.pet.pet;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

public class PetStoreModel
{
  
    public static class PetModel
    {
        public long id;
        public Category category;
        public String name;
        public List<Tag> tags;
        public String status;

        public static class Category
        {
            public long id;
            public String name;
        }

        public static class Tag
        {
            public long id;
            public String name;
        }
    }
}