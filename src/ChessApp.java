import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Created by Edward on 8/25/2016.
 */
public class ChessApp extends Application {

    public static final int TILE_SIZE = 100, WIDTH = 8, HEIGHT = 8;
    private Tile[][] board = new Tile[WIDTH][HEIGHT]; // 0,0 is top left corner
    private Group tileGroup = new Group();
    private Group pieceGroup = new Group();

    private Parent createContent() {
        Pane root = new Pane();
        root.setPrefSize(WIDTH * TILE_SIZE, HEIGHT * TILE_SIZE);
        root.getChildren().addAll(tileGroup, pieceGroup);

        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                Tile tile = new Tile((x + y) % 2 == 0, x, y);
                board[x][y] = tile;
                tileGroup.getChildren().add(tile);

                Piece piece = null;

                //White pawn @ 0,1 ; 1,1; 2,1,; ... 7,1
                //Black pawn @ 0,6 ; .... 7,6
                if (y == 1) {
                    piece = makePiece(PieceType.PAWN, PieceColor.WHITE, x, y);
                }
                else if (y == 6) {
                    piece = makePiece(PieceType.PAWN, PieceColor.BLACK, x, y);
                }
                //White rook @ 0,0 && 7,0
                //Black rook @ 0,7 && 7,7
                else if ((x == 0 || x == 7) && y == 0){
                    piece = makePiece(PieceType.ROOK, PieceColor.WHITE, x, y);
                }
                else if ((x == 0 || x == 7) && y == 7){
                    piece = makePiece(PieceType.ROOK, PieceColor.BLACK, x, y);
                }
                //TODO: Knight
                //White knight @ 1,0 && 6,0
                //Black knight @ 1,7 && 6,7
                else if ((x == 1 || x == 6) && y == 0){
                    piece = makePiece(PieceType.KNIGHT, PieceColor.WHITE, x, y);
                }
                else if ((x == 1 || x == 6) && y == 7){
                    piece = makePiece(PieceType.KNIGHT, PieceColor.BLACK, x, y);
                }

                //TODO: Bishop
                //2,0 && 5,0
                //2,7 && 5,7
                else if ((x == 2 || x == 5) && y == 0){
                    piece = makePiece(PieceType.BISHOP, PieceColor.WHITE, x, y);
                }
                else if ((x == 2 || x == 5) && y == 7){
                    piece = makePiece(PieceType.BISHOP, PieceColor.BLACK, x, y);
                }

                //TODO: Queen
                //3,0
                //3,7
                else if (x == 3 && y == 0){
                    piece = makePiece(PieceType.QUEEN, PieceColor.WHITE, x, y);
                }

                else if (x == 3 && y == 7){
                    piece = makePiece(PieceType.QUEEN, PieceColor.BLACK, x, y);
                }



                //TODO: King
                //4,0
                //4,7
                else if (x == 4 && y == 0){
                    piece = makePiece(PieceType.KING, PieceColor.WHITE, x, y);
                }
                else if (x == 4 && y == 7){
                    piece = makePiece(PieceType.KING, PieceColor.BLACK, x, y);
                }



                if (piece != null) {
                    tile.setPiece(piece);
                    pieceGroup.getChildren().add(piece);
                }
            }
        }

        return root;
    }

    private MoveResult tryMove(Piece piece, int newX, int newY){
        int x0 = toBoard(piece.getOldX());
        int y0 = toBoard(piece.getOldY());

        if (board[newX][newY].hasPiece() ||
                (piece.getType() == PieceType.PAWN && Math.abs(y0 - newY) > 1)){
            //TODO: rook, knight, bishop, queen, king
            return new MoveResult(MoveType.NORMAL);
        }

        switch(piece.getType()){
            case PAWN:
                if (Math.abs(newY - y0) == 1){
                    return new MoveResult(MoveType.NORMAL);
                }
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
        return new MoveResult(MoveType.NONE);
    }

    private int toBoard(double pixel){
        return (int)(pixel + ChessApp.TILE_SIZE / 2) / ChessApp.TILE_SIZE;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(createContent());
        primaryStage.setTitle("Chess");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Piece makePiece(PieceType type, PieceColor color, int x, int y){
        Piece piece = new Piece(type, color, x, y);

        piece.setOnMouseReleased(e-> {
            int newX = toBoard(piece.getLayoutX());
            int newY = toBoard(piece.getLayoutY());

            MoveResult result = tryMove(piece, newX, newY);

            int x0 = toBoard(piece.getOldX());
            int y0 = toBoard(piece.getOldY());

            switch(result.getType()){
                case NONE:
                    piece.abortMove();
                    break;
                case NORMAL:
                    if (piece.getColor() == PieceColor.WHITE && piece.getType() == PieceType.PAWN){
                        //TODO:
                    }
                    break;
                case SPECIAL:
                    break;
                case KILL:
                    break;
            }
        });

        return piece;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
