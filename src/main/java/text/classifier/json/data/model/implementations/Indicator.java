package text.classifier.json.data.model.implementations;

import text.classifier.json.data.model.interfaces.IIndicator;

public class Indicator implements IIndicator {
    private String name;
    private String weight;

    public Indicator() {
    }

    public Indicator(String name, String weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
}
