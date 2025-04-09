public class UpsertRequest {
    String productId;
    int delta;

    UpsertRequest(String _productId, int _delta) {
        productId = _productId;
        delta = _delta;
    }
}
