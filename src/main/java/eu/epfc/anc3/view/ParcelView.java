package eu.epfc.anc3.view;

import eu.epfc.anc3.model.Item;
import eu.epfc.anc3.model.Vegetable;
import eu.epfc.anc3.vm.ParcelViewModel;
import javafx.beans.property.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class ParcelView extends StackPane {
    private static final Image farmerImage = new Image("farmer.png");
    private static final Image dirtImage = new Image("dirt.png");
    private static final Image grassImage = new Image("grass.png");
    private static final Image carrotImage1 = new Image("carrot1.png");
    private static final Image cabbageImage1 = new Image("cabbage1.png");
    private static final Image carrotImage2 = new Image("carrot2.png");
    private static final Image cabbageImage2 = new Image("cabbage2.png");
    private static final Image carrotImage3 = new Image("carrot3.png");
    private static final Image cabbageImage3 = new Image("cabbage3.png");
    private static final Image carrotImage4 = new Image("carrot4.png");
    private static final Image cabbageImage4 = new Image("cabbage4.png");
    private static final Image rottenCarrotImage = new Image("rotten_carrot.png");
    private static final Image rottenCabbageImage = new Image("rotten_cabbage.png");

    private final ImageView frontView = new ImageView();
    private final ImageView middleFrontView = new ImageView();
    private final ImageView middleBackView = new ImageView();
    private final ImageView backView = new ImageView();

    private final SimpleListProperty<Item> itemListProperty = new SimpleListProperty<>();
    private final IntegerProperty day = new SimpleIntegerProperty(0);


    public ParcelView(ParcelViewModel parcelViewModel) {
        configBindings(parcelViewModel);
        setSizes();
        getChildren().addAll(backView, middleBackView, middleFrontView, frontView);

        setImages();
    }

    private void configBindings(ParcelViewModel parcelViewModel) {
        itemListProperty.bind(parcelViewModel.itemListProperty());
        day.bind(parcelViewModel.dayProperty());

        itemListProperty.addListener((obj, old, newVal) -> {
            setImages();
            for (Item item : itemListProperty) {
                if(item.isVegetable()) {
                    var vegetable = (Vegetable) item;
                    vegetable.actualStateEnumProperty().addListener((objV, oldV, newValV) -> {
                        setImages();
                    });
                }
            }
        });

        day.addListener((obj, old, newVal) -> {
            setImages();
        });
    }

    private void setSizes() {
        frontView.setFitWidth(30);
        frontView.setFitHeight(30);
        middleFrontView.setFitWidth(32);
        middleFrontView.setFitHeight(32);
        middleBackView.setFitWidth(32);
        middleBackView.setFitHeight(32);
        backView.setFitWidth(32);
        backView.setFitHeight(32);
    }

    private void setImages() {
        frontView.setImage(null);
        middleFrontView.setImage(null);
        middleBackView.setImage(null);

        for (Item item : itemListProperty) {
            //front
            if(item.isFarmer()) {
                frontView.setImage(farmerImage);
            } else if (item.isVegetable()) {
                //middle front
                var vegetable = (Vegetable)item;
                var state = vegetable.actualStateEnumProperty().get();

                switch (state) {
                    case CARROT_1:
                        middleFrontView.setImage(carrotImage1);
                        break;
                    case CARROT_2:
                        middleFrontView.setImage(carrotImage2);
                        break;
                    case CARROT_3:
                        middleFrontView.setImage(carrotImage3);
                        break;
                    case CARROT_4:
                        middleFrontView.setImage(carrotImage4);
                        break;
                    case CARROT_ROTTEN:
                        middleFrontView.setImage(rottenCarrotImage);
                        break;
                    case CABBAGE_1:
                        middleFrontView.setImage(cabbageImage1);
                        break;
                    case CABBAGE_2:
                        middleFrontView.setImage(cabbageImage2);
                        break;
                    case CABBAGE_3:
                        middleFrontView.setImage(cabbageImage3);
                        break;
                    case CABBAGE_4:
                        middleFrontView.setImage(cabbageImage4);
                        break;
                    case CABBAGE_ROTTEN:
                        middleFrontView.setImage(rottenCabbageImage);
                        break;
                }
            }
            //middle back
            if(item.isGrass()) {
                middleBackView.setImage(grassImage);
            }
        }
        //back
        backView.setImage(dirtImage);
    }
}
