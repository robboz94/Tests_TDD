package example;

import assertj.Animal;
import assertj.Zoo;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ZooTest {
    Zoo zoo;

    @Before
    public void before() {
        zoo = new Zoo();
    }

    @Test
    public void zoo_whenCreatingZoo_itShouldBeEmpty() {
        assertThat(zoo.getAllAnimals().isEmpty());
    }

    @Test
    public void zoo_whenAddingOneAnimal_itShouldBeTheOnlyOneAnimalInTheZoo() {

    }

    @Test
    public void zoo_whenGeneratingFunnyName() {
        String funnyName = zoo.generateFunnyName(new Animal("Anastazja"));
        assertThat(funnyName).isEqualToIgnoringCase("Anastazja");
    }

    @Test
    public void zoo_whenGeneratingNameWithPrefix_shouldReturnNameWithPrefixAtTheBeginningAndNameAtTheEnd() {
        String nameWithPrefix = zoo.generateNameWithPrefix(new Animal("Adam"));
        assertThat(nameWithPrefix)
                .endsWith("Adam")
                .startsWith("Zwierzatko");
    }
    @Test
    public void zoo_(){
        String funnyName = zoo.generateFunnyName(new Animal("Anastazja"));
        assertThat(funnyName).isEqualToIgnoringCase("Anastazja");
    }
    @Test
    public void zoo_whenAddingTwoAnimalsToZoo_ShouldBeOnlyThoseTwoAnimalsInTheZoo() {
        Animal anastazja = new Animal("Anastazja");
        Animal adam = new Animal("Adam");

        zoo.addAnimal(anastazja);
        zoo.addAnimal(adam);

        assertThat(zoo.getAllAnimals())
                .containsOnly(anastazja, adam)
                .extracting(Animal::getName)
                .containsOnly("Anastazja", "Adam");
    }
}
