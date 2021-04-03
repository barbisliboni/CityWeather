package com.barbara.weather.model;

	import java.io.IOException;
	import java.net.URI;
	import java.net.URISyntaxException;
	import java.net.http.HttpClient;
	import java.net.http.HttpRequest;
	import java.net.http.HttpResponse;

	public class Request {
		
		private URI url;
		
		public HttpResponse<String> GET() throws IOException, InterruptedException {
			HttpRequest request = HttpRequest.newBuilder(url).GET().build();
			
			return HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		}

		public URI getUrl() {
			return url;
		}

		public void setUrl(String url) throws URISyntaxException {
			this.url = new URI(url);
		}
		
}
