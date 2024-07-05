import json
import pandas as pd
from flask import Flask, request, jsonify

app = Flask(__name__)

# Dummy financial data
data = [
    {"symbol": "AAPL", "date": "2023-01-01", "open": 150.0, "close": 155.0, "high": 157.0, "low": 148.0, "volume": 1000000},
    {"symbol": "AAPL", "date": "2023-01-02", "open": 155.0, "close": 158.0, "high": 160.0, "low": 154.0, "volume": 1200000}
]

df = pd.DataFrame(data)

@app.route('/')
def home():
    return 'Welcome to my Flask application'

@app.route('/financial_data', methods=['GET'])
def get_financial_data():
    symbol = request.args.get('symbol')
    if not symbol:
        return jsonify({"error": "Symbol parameter is required"}), 400

    filtered_data = df[df['symbol'] == symbol]
    result = filtered_data.to_dict(orient='records')
    result_json = json.dumps(result, default=str)
    return result_json

@app.route('/analyze', methods=['GET', 'POST'])
def analyze_data():
    if request.method == 'GET':
        return 'Welcome to analysis endpoint. Please use POST method for analysis.'

    if request.method == 'POST':
        request_data = request.json
        df = pd.DataFrame(request_data)

        # Perform advanced analysis
        analysis_result = {
            "average_open": df['open'].mean(),
            "average_close": df['close'].mean(),
            "average_high": df['high'].mean(),
            "average_low": df['low'].mean(),
            "total_volume": df['volume'].sum(),
            "moving_average": df['close'].rolling(window=5).mean().fillna(0).tolist(),
            "RSI": calculate_rsi(df['close'], 14).fillna(0).tolist()
        }
        # Convert all numpy and pandas data types to native Python types
        analysis_result = json.loads(json.dumps(analysis_result, default=lambda x: x if isinstance(x, (int, float)) else str(x)))
        return jsonify(analysis_result)

def calculate_rsi(series, period):
    delta = series.diff()
    gain = (delta.where(delta > 0, 0)).rolling(window=period).mean()
    loss = (-delta.where(delta < 0, 0)).rolling(window=period).mean()
    rs = gain / loss
    rsi = 100 - (100 / (1 + rs))
    return rsi

if __name__ == '__main__':
    app.run(debug=True)
