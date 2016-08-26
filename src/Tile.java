import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Created by Edward on 8/25/2016.
 */
public class Tile extends Rectangle {
    private Piece piece;

    public boolean hasPiece(){
        return piece != null;
    }

    public Piece getPiece(){
        return piece;
    }

    public void setPiece(Piece piece){
        this.piece = piece;
    }

    public Tile(boolean light, int x, int y){
        setWidth(ChessApp.TILE_SIZE);
        setHeight(ChessApp.TILE_SIZE);

        relocate(x * ChessApp.TILE_SIZE, y * ChessApp.TILE_SIZE);

        setFill(light ? Color.valueOf("#996600") : Color.valueOf("#ffcc66"));
    }
}
