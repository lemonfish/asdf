
package net.asdf.core.query;

import org.apache.commons.codec.digest.Md5Crypt;

public class Query {

	private String id;

	private String query;

	private String checksum;

	private long lastModified;

	public Query() {

	}

	public Query(String resourceURI, int queryIdLineNo, String id, StringBuilder query, long lastModified) {
		this.id = id;
		// NOTE Sha2Crypt 대비 md5 가 훨 빠르다. 쿼리야... 충돌나도 뭐 크게 문제될게...
		checksum = Md5Crypt.md5Crypt(query.toString().getBytes());
		this.query = query.insert(0, String.format("\n/* QueryId : %s (%s:%d) */\n\n", id, resourceURI, queryIdLineNo)).toString();

		this.lastModified = lastModified;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public long getLastModified() {
		return lastModified;
	}

	public void setLastModified(long lastModified) {
		this.lastModified = lastModified;
	}

	/**
	 * @return the checksum
	 */
	public String getChecksum() {
		return checksum;
	}

}
