API BCA - https://developer.bca.co.id/apis

1. Ubah file Keys.java (id.co.bca.sandbox.api_services.Keys) dengan keys yang anda peroleh dari https://developer.bca.co.id/sign-in

2. Tambahkan INTERNET permission di AndroidManifest.xml

	`<uses-permission android:name="android.permission.INTERNET"/>`

3. Tambahkan dependencies sbb:

	`implementation 'com.android.volley:volley:1.1.1'`
	
	`implementation 'com.google.code.gson:gson:2.8.5'`

4. Contoh Authentication:

	```java
	this.bcaApiPresenter.getAccessToken(this, new AccessTokenResult() {
		@Override
		public void onSuccess(AccessTokenResponse response) {
			try {
				if (response != null) {
					logTextView.append("-- ACCESS TOKEN  --\n");
					logTextView.append("access_token: { " + response.getAccessToken() + " }\n");
					logTextView.append("token_type: { " + response.getTokenType() + " }\n");
					logTextView.append("expires_in: { " + response.getExpiresIn() + " }\n");
					logTextView.append("scope: { " + response.getScope() + " }\n");
					logTextView.append("\n");
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		@Override
		public void onError(VolleyError response) {
			try {
				logTextView.append("-- ACCESS TOKEN  --\n");
				logTextView.append(parseVolleyError("getAccessToken()", response) + "\n");
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	});

	```

5. Contoh BusinessBanking:

	```java

	this.bcaApiPresenter.getBalanceInfo(this, new BalanceInfoRequest("BCAAPI2016", new ArrayList<>(Arrays.asList("0201245680", "0063001004"))), new BalanceInfoResult() {

		@Override
		public void onSuccess(List<BalanceInfoSuccessResponse> response) {
			try {
				if (response != null && response.size() > 0) {
					logTextView.append("-- BALANCE INFORMATION --\n");

					for (int i = 0; i < response.size(); i++) {
						BalanceInfoSuccessResponse successResponse = response.get(i);
						if (successResponse != null) {
							logTextView.append("account_number: { " + successResponse.getAccountNumber() + " }\n");
							logTextView.append("currency: { " + successResponse.getCurrency() + " }\n");
							logTextView.append("balance: { " + successResponse.getBalance() + " }\n");
							logTextView.append("available_balance: { " + successResponse.getAvailableBalance() + " }\n");
							logTextView.append("float_amount: { " + successResponse.getFloatAmount() + " }\n");
							logTextView.append("hold_amount: { " + successResponse.getHoldAmount() + " }\n");
							logTextView.append("plafon: { " + successResponse.getPlafon() + " }\n");
							logTextView.append("\n");
						}
					}
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		@Override
		public void onFailed(List<BalanceInfoFailedResponse> response) {
			try {
				if (response != null && response.size() > 0) {
					logTextView.append("-- BALANCE INFORMATION --\n");

					for (int i = 0; i < response.size(); i++) {
						BalanceInfoFailedResponse failedResponse = response.get(i);
						if (failedResponse != null) {
							logTextView.append("English: { " + failedResponse.getEnglish() + " }\n");
							logTextView.append("Indonesian: { " + failedResponse.getIndonesian() + " }\n");
							logTextView.append("AccountNumber: { " + failedResponse.getAccountNumber() + " }\n");
							logTextView.append("\n");
						}
					}
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		@Override
		public void onError(VolleyError response) {
			try {
				logTextView.append("-- BALANCE INFORMATION --\n");
				logTextView.append(parseVolleyError("getBalanceInfo()", response) + "\n");
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	});


	this.bcaApiPresenter.getAccountStatement(this, new AccountStatementRequest("BCAAPI2016", "0201245680", "2016-09-01", "2016-09-01"), new AccountStatementResult() {
		@Override
		public void onSuccess(AccountStatementResponse response) {
			try {
				if (response != null) {
					logTextView.append("-- ACCOUNT STATEMENT --\n");
					logTextView.append("start_date: { " + response.getStartDate() + " }\n");
					logTextView.append("end_date: { " + response.getEndDate() + " }\n");
					logTextView.append("currency: { " + response.getCurrency() + " }\n");
					logTextView.append("start_balance: { " + response.getStartBalance() + " }\n\n");

					List<Data> list = response.getDataTransaction();
					if (list != null) {
						for (int i = 0; i < list.size(); i++) {
							Data item = list.get(i);
							if (item != null) {
								int n = i + 1;
								logTextView.append("\t" + n + ".\ttransaction_date: { " + item.getTransactionDate() + " }\n");
								logTextView.append("\t" + " " + "\t\tbranch_code: { " + item.getBranchCode() + " }\n");
								logTextView.append("\t" + " " + "\t\ttransaction_type: { " + item.getTransactionType() + " }\n");
								logTextView.append("\t" + " " + "\t\ttransaction_amount: { " + item.getTransactionAmount() + " }\n");
								logTextView.append("\t" + " " + "\t\ttransaction_name: { " + item.getTransactionName() + " }\n");
								logTextView.append("\t" + " " + "\t\ttransaction_trailer: { " + item.getTrailer() + " }\n\n");
							}
						}
					}
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		@Override
		public void onError(VolleyError response) {
			try {
				if (response != null) {
					logTextView.append("-- ACCOUNT STATEMENT --\n");
					logTextView.append(parseVolleyError("getAccountStatement()", response) + "\n");
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	});


	this.bcaApiPresenter.fundTransfer(this, new FundTransferRequest("BCAAPI2016", "0201245680", "00000001", getCurrrentDate(), "12345/PO/2016", "IDR", "100000.00", "0201245681", "Transfer Test", "Online Transfer"), new FundTransferResult() {
		@Override
		public void onSuccess(FundTransferResponse response) {
			try {
				if (response != null) {
					logTextView.append("-- FUND TRANSFER --\n");
					logTextView.append("transaction_id: { " + response.getTransactionId() + " }\n");
					logTextView.append("transaction_date: { " + response.getTransactionDate() + " }\n");
					logTextView.append("reference_id: { " + response.getReferenceId() + " }\n");
					logTextView.append("status: { " + response.getStatus() + " }\n");
					logTextView.append("\n");
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		@Override
		public void onError(VolleyError response) {
			try {
				if (response != null) {
					logTextView.append("-- FUND TRANSFER --\n");
					logTextView.append(parseVolleyError("fundTransfer()", response) + "\n");
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	});


	this.bcaApiPresenter.domesticFundTransfer(this, new DomesticFundTransferRequest("00000001", getCurrrentDate(), "12345/PO/2016", "0201245680", "0201245501", "BRONINJA", "Tester", "100000.00", "LLG", "1", "1", "IDR", "Transfer Test", "Online Transfer", "95051", "BCAAPI"), new DomesticFundTransferResult() {
		@Override
		public void onSuccess(DomesticFundTransferResponse response) {
			try {
				if (response != null) {
					logTextView.append("-- DOMESTIC FUND TRANSFER --\n");
					logTextView.append("transaction_id: { " + response.getTransactionID() + " }\n");
					logTextView.append("transaction_date: { " + response.getTransactionDate() + " }\n");
					logTextView.append("reference_id: { " + response.getReferenceID() + " }\n");
					logTextView.append("ppu_number: { " + response.getPPUNumber() + " }\n");
					logTextView.append("\n");
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		@Override
		public void onError(VolleyError response) {
			try {
				if (response != null) {
					logTextView.append("-- DOMESTIC FUND TRANSFER --\n");
					logTextView.append(parseVolleyError("domesticFundTransfer()", response) + "\n");
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	});

	```

6. Hasil Output

	![alt text](https://github.com/saveuighur81/bca-api/blob/master/Screenshot_2018-12-17_114101.jpg)
