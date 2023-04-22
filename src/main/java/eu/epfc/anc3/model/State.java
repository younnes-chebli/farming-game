package eu.epfc.anc3.model;

public interface State {
    double grow(int day);
    void fertilize();
    double harvest(int day);
}
