import okhttp3.*;

public class OkHttpDemo {
	public static void test() {
		  final MediaType JSON = MediaType.get("application/json; charset=utf-8");
			OkHttpClient client = new OkHttpClient();
			//构造builder
			Request.Builder header = new Request.Builder().url("http://www.baidu.com").header("Content-Type", "application/json");
			//构造请求体
			RequestBody data = RequestBody.create(JSON, "json数据");
			//构造请求
			Request build = header.post(data).build();

			//发送请求请求
			try (Response response = client.newCall(build).execute()) {
				System.out.println("返回结果start");
				 response.body().string();
				System.out.println("返回结果end");

			} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public static void test1() {
		final MediaType JSON = MediaType.get("application/json; charset=utf-8");
		OkHttpClient client = new OkHttpClient();
		Request build = new Request.Builder().url("http://www.baidu.com").header("Content-Type", "application/json").post(RequestBody.create(JSON, "json数据")).build();
		//发送请求请求
		try (Response response = client.newCall(build).execute()) {
			System.out.println("返回结果start");
			response.body().string();
			System.out.println("返回结果end");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public static void test2() {
		final MediaType JSON = MediaType.get("application/json; charset=utf-8");
		OkHttpClient client = new OkHttpClient();

		RequestBody body = RequestBody.create(JSON, "json数据");
		Request request = new Request.Builder()
				.header("Content-Type", "application/json")
				.url("http://www.baidu.com")
				.post(body)
				.build();
		//发送请求请求
		try (Response response = client.newCall(request).execute()) {
			System.out.println("返回结果start");
			response.body().string();
			System.out.println("返回结果end");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		test();
	}
}
