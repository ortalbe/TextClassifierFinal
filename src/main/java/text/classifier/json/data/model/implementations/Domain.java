package text.classifier.json.data.model.implementations;

import text.classifier.json.data.model.interfaces.IDomain;

public class Domain implements IDomain {

    private String domainValue;
    private Double weight;

    public Domain() {
    }

    public Domain(String domain, Double weight) {
        this.domainValue = domain;
        this.weight = weight;
    }

    @Override
    public String getDomainValue() {
        return domainValue;
    }

    @Override
    public void setDomainValue(String name) {
        domainValue = name;
    }

    @Override
    public Double getWeight() {
        return weight;
    }

    @Override
    public void setWeight(Double weight) {
        this.weight=weight;
    }
}
