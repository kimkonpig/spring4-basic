package chap02.search;

public interface SearchClientFactory {
    public void init();
    public SearchClient create();
}
