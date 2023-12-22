# Google Books API を試したアプリ
## 機能
入力したキーワードを元に本のデータを取得して表示するだけ
## 使い方
1 入力欄にキーワードを入力

2 検索を押す

3 出てきたタイトルを押すと詳細表示

## 実装で詰まったところ
1 APIのインターフェースを suspend fun にし忘れた

2 CoilでURLから画像を取得するときに、http通信の場合はパーミッションの設定がいることを知らなかった

## 学び
・Retrofit の使い方

・kotlin-serialization の使い方

・エラーに対して、e.message の他に e.cause も合わせて使う

![image](https://github.com/dennoko/BookSearchApp/assets/145789995/f3f3f8b9-5f12-4cd3-8525-45c8705c7b21)
![image](https://github.com/dennoko/BookSearchApp/assets/145789995/dcf0af72-f62c-498a-926b-f30b52d7f079)


