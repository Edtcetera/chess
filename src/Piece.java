import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;

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

        //TODO: depending on type, load asset image and place on board
        switch(type){
            case PAWN:
                //TODO:
                break;
            case ROOK:
                //TODO:
                break;
            case KNIGHT:
                //TODO:
                break;
            case BISHOP:
                //TODO:
                break;
            case QUEEN:
                //TODO:
                break;
            case KING:
                //TODO:
                break;
        }
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
