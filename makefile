


over-all-create: 
	cd ./AuthService && $(MAKE) k8s-all-create && cd ../BankService && $(MAKE) k8s-all-create && cd ../CartService && $(MAKE) k8s-all-create && cd ../CreditCardService && $(MAKE) k8s-all-create && cd ../OrderService && $(MAKE) k8s-all-create && cd ../PaymentService && $(MAKE) k8s-all-create && cd ../PaypalService && $(MAKE) k8s-all-create && cd ../ProductService && $(MAKE) k8s-all-create && cd ../UserService && $(MAKE) k8s-all-create
over-all-delete: 
	cd ./AuthService && $(MAKE) k8s-all-delete && cd ../BankService && $(MAKE) k8s-all-delete && cd ../CartService && $(MAKE) k8s-all-delete && cd ../CreditCardService && $(MAKE) k8s-all-delete && cd ../OrderService && $(MAKE) k8s-all-delete && cd ../PaymentService && $(MAKE) k8s-all-delete && cd ../PaypalService && $(MAKE) k8s-all-delete && cd ../ProductService && $(MAKE) k8s-all-delete && cd ../UserService && $(MAKE) k8s-all-delete


burn: over-all-delete over-all-create

slice: docker rmi -f $(docker images -a -q)







