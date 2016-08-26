import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

/**
 * Created by Edward on 8/25/2016.
 */
public class Piece extends StackPane {
    private PieceType type;
    private PieceColor color;

    private double mouseX, mouseY;
    private double oldX, oldY;

    public PieceType getType(){
        return type;
    }

    public PieceColor getColor(){
        return color;
    }

    public double getOldX(){
        return oldX;
    }

    public double getOldY(){
        return oldY;
    }

    public Piece(PieceType type, PieceColor color, int x, int y){
        this.type = type;
        this.color = color;

        move(x,y);
        ImageView iv = new ImageView();
        iv.setFitHeight(ChessApp.TILE_SIZE * 0.8);
        iv.setPreserveRatio(true);
        Image piece = null;

        //TODO: depending on type, load asset image and place on board
        switch(type){
            case PAWN:
                if (color == PieceColor.WHITE){
                    piece = new Image ("PawnW.png");
                }
                else if (color == PieceColor.BLACK){
                    piece = new Image ("PawnB.png");
                }
                break;
            case ROOK:
                if (color == PieceColor.WHITE){
                    piece = new Image ("PawnW.png");
                }
                else if (color == PieceColor.BLACK){
                    piece = new Image ("PawnB.png");
                }
                break;
            case KNIGHT:
                if (color == PieceColor.WHITE){
                    piece = new Image ("PawnW.png");
                }
                else if (color == PieceColor.BLACK){
                    piece = new Image ("PawnB.png");
                }
                break;
            case BISHOP:
                if (color == PieceColor.WHITE){
                    piece = new Image ("PawnW.png");
                }
                else if (color == PieceColor.BLACK){
                    piece = new Image ("PawnB.png");
                }
                break;
            case QUEEN:
                if (color == PieceColor.WHITE){
                    piece = new Image ("PawnW.png");
                }
                else if (color == PieceColor.BLACK){
                    piece = new Image ("PawnB.png");
                }
                break;
            case KING:
                if (color == PieceColor.WHITE){
                    piece = new Image ("PawnW.png");
                }
                else if (color == PieceColor.BLACK){
                    piece = new Image ("PawnB.png");
                }
                break;
        }
        iv.setImage(piece);
        getChildren().add(iv);

        setOnMousePressed(e -> {
            mouseX = e.getSceneX();
            mouseY = e.getSceneY();
        });

        setOnMouseDragged(e ->{
            relocate(e.getSceneX() - mouseX + oldX, e.getSceneY() - mouseY + oldY);
        });
    }

    public void move(int x, int y){
        oldX = x * ChessApp.TILE_SIZE;
        oldY = y * ChessApp.TILE_SIZE;
        relocate(oldX, oldY);
    }

    public void abortMove(){
        relocate(oldX, oldY);
    }
}
