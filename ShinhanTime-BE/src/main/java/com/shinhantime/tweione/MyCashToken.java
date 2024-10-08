package com.shinhantime.tweione;

import io.reactivex.Flowable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/hyperledger/web3j/tree/main/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 1.6.1.
 */
@SuppressWarnings("rawtypes")
public class MyCashToken extends Contract {
    public static final String BINARY = "60806040523480156200001157600080fd5b506040516200242438038062002424833981810160405281019062000037919062000387565b6040518060400160405280600681526020017f4d794361736800000000000000000000000000000000000000000000000000008152506040518060400160405280600381526020017f4d435400000000000000000000000000000000000000000000000000000000008152508160039081620000b4919062000629565b508060049081620000c6919062000629565b505050620000e9620000dd6200010260201b60201c565b6200010a60201b60201c565b620000fb3382620001d060201b60201c565b506200082b565b600033905090565b6000600560009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16905081600560006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055508173ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff167f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e060405160405180910390a35050565b600073ffffffffffffffffffffffffffffffffffffffff168273ffffffffffffffffffffffffffffffffffffffff160362000242576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401620002399062000771565b60405180910390fd5b62000256600083836200033d60201b60201c565b80600260008282546200026a9190620007c2565b92505081905550806000808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600082825401925050819055508173ffffffffffffffffffffffffffffffffffffffff16600073ffffffffffffffffffffffffffffffffffffffff167fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef836040516200031d91906200080e565b60405180910390a362000339600083836200034260201b60201c565b5050565b505050565b505050565b600080fd5b6000819050919050565b62000361816200034c565b81146200036d57600080fd5b50565b600081519050620003818162000356565b92915050565b600060208284031215620003a0576200039f62000347565b5b6000620003b08482850162000370565b91505092915050565b600081519050919050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052604160045260246000fd5b7f4e487b7100000000000000000000000000000000000000000000000000000000600052602260045260246000fd5b600060028204905060018216806200043b57607f821691505b602082108103620004515762000450620003f3565b5b50919050565b60008190508160005260206000209050919050565b60006020601f8301049050919050565b600082821b905092915050565b600060088302620004bb7fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff826200047c565b620004c786836200047c565b95508019841693508086168417925050509392505050565b6000819050919050565b60006200050a62000504620004fe846200034c565b620004df565b6200034c565b9050919050565b6000819050919050565b6200052683620004e9565b6200053e620005358262000511565b84845462000489565b825550505050565b600090565b6200055562000546565b620005628184846200051b565b505050565b5b818110156200058a576200057e6000826200054b565b60018101905062000568565b5050565b601f821115620005d957620005a38162000457565b620005ae846200046c565b81016020851015620005be578190505b620005d6620005cd856200046c565b83018262000567565b50505b505050565b600082821c905092915050565b6000620005fe60001984600802620005de565b1980831691505092915050565b6000620006198383620005eb565b9150826002028217905092915050565b6200063482620003b9565b67ffffffffffffffff81111562000650576200064f620003c4565b5b6200065c825462000422565b620006698282856200058e565b600060209050601f831160018114620006a157600084156200068c578287015190505b6200069885826200060b565b86555062000708565b601f198416620006b18662000457565b60005b82811015620006db57848901518255600182019150602085019450602081019050620006b4565b86831015620006fb5784890151620006f7601f891682620005eb565b8355505b6001600288020188555050505b505050505050565b600082825260208201905092915050565b7f45524332303a206d696e7420746f20746865207a65726f206164647265737300600082015250565b600062000759601f8362000710565b9150620007668262000721565b602082019050919050565b600060208201905081810360008301526200078c816200074a565b9050919050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052601160045260246000fd5b6000620007cf826200034c565b9150620007dc836200034c565b9250828201905080821115620007f757620007f662000793565b5b92915050565b62000808816200034c565b82525050565b6000602082019050620008256000830184620007fd565b92915050565b611be9806200083b6000396000f3fe608060405234801561001057600080fd5b50600436106101005760003560e01c8063715018a611610097578063a457c2d711610066578063a457c2d71461029d578063a9059cbb146102cd578063dd62ed3e146102fd578063f2fde38b1461032d57610100565b8063715018a61461023b5780638da5cb5b1461024557806395d89b4114610263578063a3ffa9cd1461028157610100565b80632e1a7d4d116100d35780632e1a7d4d146101a1578063313ce567146101bd57806339509351146101db57806370a082311461020b57610100565b806306fdde0314610105578063095ea7b31461012357806318160ddd1461015357806323b872dd14610171575b600080fd5b61010d610349565b60405161011a9190611175565b60405180910390f35b61013d60048036038101906101389190611230565b6103db565b60405161014a919061128b565b60405180910390f35b61015b6103fe565b60405161016891906112b5565b60405180910390f35b61018b600480360381019061018691906112d0565b610408565b604051610198919061128b565b60405180910390f35b6101bb60048036038101906101b69190611323565b610437565b005b6101c561048f565b6040516101d2919061136c565b60405180910390f35b6101f560048036038101906101f09190611230565b610498565b604051610202919061128b565b60405180910390f35b61022560048036038101906102209190611387565b6104cf565b60405161023291906112b5565b60405180910390f35b610243610517565b005b61024d61052b565b60405161025a91906113c3565b60405180910390f35b61026b610555565b6040516102789190611175565b60405180910390f35b61029b60048036038101906102969190611230565b6105e7565b005b6102b760048036038101906102b29190611230565b6105fd565b6040516102c4919061128b565b60405180910390f35b6102e760048036038101906102e29190611230565b610674565b6040516102f4919061128b565b60405180910390f35b610317600480360381019061031291906113de565b610697565b60405161032491906112b5565b60405180910390f35b61034760048036038101906103429190611387565b61071e565b005b6060600380546103589061144d565b80601f01602080910402602001604051908101604052809291908181526020018280546103849061144d565b80156103d15780601f106103a6576101008083540402835291602001916103d1565b820191906000526020600020905b8154815290600101906020018083116103b457829003601f168201915b5050505050905090565b6000806103e66107a1565b90506103f38185856107a9565b600191505092915050565b6000600254905090565b6000806104136107a1565b9050610420858285610972565b61042b8585856109fe565b60019150509392505050565b80610441336104cf565b1015610482576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401610479906114ca565b60405180910390fd5b61048c3382610c74565b50565b60006012905090565b6000806104a36107a1565b90506104c48185856104b58589610697565b6104bf9190611519565b6107a9565b600191505092915050565b60008060008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020549050919050565b61051f610e41565b6105296000610ebf565b565b6000600560009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16905090565b6060600480546105649061144d565b80601f01602080910402602001604051908101604052809291908181526020018280546105909061144d565b80156105dd5780601f106105b2576101008083540402835291602001916105dd565b820191906000526020600020905b8154815290600101906020018083116105c057829003601f168201915b5050505050905090565b6105ef610e41565b6105f98282610f85565b5050565b6000806106086107a1565b905060006106168286610697565b90508381101561065b576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401610652906115bf565b60405180910390fd5b61066882868684036107a9565b60019250505092915050565b60008061067f6107a1565b905061068c8185856109fe565b600191505092915050565b6000600160008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002054905092915050565b610726610e41565b600073ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff1603610795576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161078c90611651565b60405180910390fd5b61079e81610ebf565b50565b600033905090565b600073ffffffffffffffffffffffffffffffffffffffff168373ffffffffffffffffffffffffffffffffffffffff1603610818576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161080f906116e3565b60405180910390fd5b600073ffffffffffffffffffffffffffffffffffffffff168273ffffffffffffffffffffffffffffffffffffffff1603610887576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161087e90611775565b60405180910390fd5b80600160008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020819055508173ffffffffffffffffffffffffffffffffffffffff168373ffffffffffffffffffffffffffffffffffffffff167f8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b9258360405161096591906112b5565b60405180910390a3505050565b600061097e8484610697565b90507fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff81146109f857818110156109ea576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016109e1906117e1565b60405180910390fd5b6109f784848484036107a9565b5b50505050565b600073ffffffffffffffffffffffffffffffffffffffff168373ffffffffffffffffffffffffffffffffffffffff1603610a6d576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401610a6490611873565b60405180910390fd5b600073ffffffffffffffffffffffffffffffffffffffff168273ffffffffffffffffffffffffffffffffffffffff1603610adc576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401610ad390611905565b60405180910390fd5b610ae78383836110db565b60008060008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002054905081811015610b6d576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401610b6490611997565b60405180910390fd5b8181036000808673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002081905550816000808573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600082825401925050819055508273ffffffffffffffffffffffffffffffffffffffff168473ffffffffffffffffffffffffffffffffffffffff167fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef84604051610c5b91906112b5565b60405180910390a3610c6e8484846110e0565b50505050565b600073ffffffffffffffffffffffffffffffffffffffff168273ffffffffffffffffffffffffffffffffffffffff1603610ce3576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401610cda90611a29565b60405180910390fd5b610cef826000836110db565b60008060008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002054905081811015610d75576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401610d6c90611abb565b60405180910390fd5b8181036000808573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000208190555081600260008282540392505081905550600073ffffffffffffffffffffffffffffffffffffffff168373ffffffffffffffffffffffffffffffffffffffff167fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef84604051610e2891906112b5565b60405180910390a3610e3c836000846110e0565b505050565b610e496107a1565b73ffffffffffffffffffffffffffffffffffffffff16610e6761052b565b73ffffffffffffffffffffffffffffffffffffffff1614610ebd576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401610eb490611b27565b60405180910390fd5b565b6000600560009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16905081600560006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055508173ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff167f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e060405160405180910390a35050565b600073ffffffffffffffffffffffffffffffffffffffff168273ffffffffffffffffffffffffffffffffffffffff1603610ff4576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401610feb90611b93565b60405180910390fd5b611000600083836110db565b80600260008282546110129190611519565b92505081905550806000808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600082825401925050819055508173ffffffffffffffffffffffffffffffffffffffff16600073ffffffffffffffffffffffffffffffffffffffff167fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef836040516110c391906112b5565b60405180910390a36110d7600083836110e0565b5050565b505050565b505050565b600081519050919050565b600082825260208201905092915050565b60005b8381101561111f578082015181840152602081019050611104565b60008484015250505050565b6000601f19601f8301169050919050565b6000611147826110e5565b61115181856110f0565b9350611161818560208601611101565b61116a8161112b565b840191505092915050565b6000602082019050818103600083015261118f818461113c565b905092915050565b600080fd5b600073ffffffffffffffffffffffffffffffffffffffff82169050919050565b60006111c78261119c565b9050919050565b6111d7816111bc565b81146111e257600080fd5b50565b6000813590506111f4816111ce565b92915050565b6000819050919050565b61120d816111fa565b811461121857600080fd5b50565b60008135905061122a81611204565b92915050565b6000806040838503121561124757611246611197565b5b6000611255858286016111e5565b92505060206112668582860161121b565b9150509250929050565b60008115159050919050565b61128581611270565b82525050565b60006020820190506112a0600083018461127c565b92915050565b6112af816111fa565b82525050565b60006020820190506112ca60008301846112a6565b92915050565b6000806000606084860312156112e9576112e8611197565b5b60006112f7868287016111e5565b9350506020611308868287016111e5565b92505060406113198682870161121b565b9150509250925092565b60006020828403121561133957611338611197565b5b60006113478482850161121b565b91505092915050565b600060ff82169050919050565b61136681611350565b82525050565b6000602082019050611381600083018461135d565b92915050565b60006020828403121561139d5761139c611197565b5b60006113ab848285016111e5565b91505092915050565b6113bd816111bc565b82525050565b60006020820190506113d860008301846113b4565b92915050565b600080604083850312156113f5576113f4611197565b5b6000611403858286016111e5565b9250506020611414858286016111e5565b9150509250929050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052602260045260246000fd5b6000600282049050600182168061146557607f821691505b6020821081036114785761147761141e565b5b50919050565b7f496e73756666696369656e742062616c616e6365000000000000000000000000600082015250565b60006114b46014836110f0565b91506114bf8261147e565b602082019050919050565b600060208201905081810360008301526114e3816114a7565b9050919050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052601160045260246000fd5b6000611524826111fa565b915061152f836111fa565b9250828201905080821115611547576115466114ea565b5b92915050565b7f45524332303a2064656372656173656420616c6c6f77616e63652062656c6f7760008201527f207a65726f000000000000000000000000000000000000000000000000000000602082015250565b60006115a96025836110f0565b91506115b48261154d565b604082019050919050565b600060208201905081810360008301526115d88161159c565b9050919050565b7f4f776e61626c653a206e6577206f776e657220697320746865207a65726f206160008201527f6464726573730000000000000000000000000000000000000000000000000000602082015250565b600061163b6026836110f0565b9150611646826115df565b604082019050919050565b6000602082019050818103600083015261166a8161162e565b9050919050565b7f45524332303a20617070726f76652066726f6d20746865207a65726f2061646460008201527f7265737300000000000000000000000000000000000000000000000000000000602082015250565b60006116cd6024836110f0565b91506116d882611671565b604082019050919050565b600060208201905081810360008301526116fc816116c0565b9050919050565b7f45524332303a20617070726f766520746f20746865207a65726f20616464726560008201527f7373000000000000000000000000000000000000000000000000000000000000602082015250565b600061175f6022836110f0565b915061176a82611703565b604082019050919050565b6000602082019050818103600083015261178e81611752565b9050919050565b7f45524332303a20696e73756666696369656e7420616c6c6f77616e6365000000600082015250565b60006117cb601d836110f0565b91506117d682611795565b602082019050919050565b600060208201905081810360008301526117fa816117be565b9050919050565b7f45524332303a207472616e736665722066726f6d20746865207a65726f20616460008201527f6472657373000000000000000000000000000000000000000000000000000000602082015250565b600061185d6025836110f0565b915061186882611801565b604082019050919050565b6000602082019050818103600083015261188c81611850565b9050919050565b7f45524332303a207472616e7366657220746f20746865207a65726f206164647260008201527f6573730000000000000000000000000000000000000000000000000000000000602082015250565b60006118ef6023836110f0565b91506118fa82611893565b604082019050919050565b6000602082019050818103600083015261191e816118e2565b9050919050565b7f45524332303a207472616e7366657220616d6f756e742065786365656473206260008201527f616c616e63650000000000000000000000000000000000000000000000000000602082015250565b60006119816026836110f0565b915061198c82611925565b604082019050919050565b600060208201905081810360008301526119b081611974565b9050919050565b7f45524332303a206275726e2066726f6d20746865207a65726f2061646472657360008201527f7300000000000000000000000000000000000000000000000000000000000000602082015250565b6000611a136021836110f0565b9150611a1e826119b7565b604082019050919050565b60006020820190508181036000830152611a4281611a06565b9050919050565b7f45524332303a206275726e20616d6f756e7420657863656564732062616c616e60008201527f6365000000000000000000000000000000000000000000000000000000000000602082015250565b6000611aa56022836110f0565b9150611ab082611a49565b604082019050919050565b60006020820190508181036000830152611ad481611a98565b9050919050565b7f4f776e61626c653a2063616c6c6572206973206e6f7420746865206f776e6572600082015250565b6000611b116020836110f0565b9150611b1c82611adb565b602082019050919050565b60006020820190508181036000830152611b4081611b04565b9050919050565b7f45524332303a206d696e7420746f20746865207a65726f206164647265737300600082015250565b6000611b7d601f836110f0565b9150611b8882611b47565b602082019050919050565b60006020820190508181036000830152611bac81611b70565b905091905056fea264697066735822122031b0faeb90c31161f1aff16315bd1ef780a832e153919f6647b13e4934d6443464736f6c63430008130033";

    private static String librariesLinkedBinary;

    public static final String FUNC_ALLOWANCE = "allowance";

    public static final String FUNC_APPROVE = "approve";

    public static final String FUNC_BALANCEOF = "balanceOf";

    public static final String FUNC_CHARGE = "charge";

    public static final String FUNC_DECIMALS = "decimals";

    public static final String FUNC_DECREASEALLOWANCE = "decreaseAllowance";

    public static final String FUNC_INCREASEALLOWANCE = "increaseAllowance";

    public static final String FUNC_NAME = "name";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_RENOUNCEOWNERSHIP = "renounceOwnership";

    public static final String FUNC_SYMBOL = "symbol";

    public static final String FUNC_TOTALSUPPLY = "totalSupply";

    public static final String FUNC_TRANSFER = "transfer";

    public static final String FUNC_TRANSFERFROM = "transferFrom";

    public static final String FUNC_TRANSFEROWNERSHIP = "transferOwnership";

    public static final String FUNC_WITHDRAW = "withdraw";

    public static final Event APPROVAL_EVENT = new Event("Approval", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event OWNERSHIPTRANSFERRED_EVENT = new Event("OwnershipTransferred", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}));
    ;

    public static final Event TRANSFER_EVENT = new Event("Transfer", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}));
    ;

    @Deprecated
    protected MyCashToken(String contractAddress, Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected MyCashToken(String contractAddress, Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected MyCashToken(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected MyCashToken(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static List<ApprovalEventResponse> getApprovalEvents(
            TransactionReceipt transactionReceipt) {
        List<ApprovalEventResponse> responses = new ArrayList<>();

        // Iterate through each log in the transaction receipt
        for (Log log : transactionReceipt.getLogs()) {
            // Extract event parameters from the log
            Contract.EventValuesWithLog eventValues = Contract.staticExtractEventParametersWithLog(APPROVAL_EVENT, log);
            if (eventValues != null) {
                ApprovalEventResponse typedResponse = new ApprovalEventResponse();
                typedResponse.log = eventValues.getLog();
                typedResponse.owner = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.spender = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                responses.add(typedResponse);
            }
        }
        return responses;
    }

    public static ApprovalEventResponse getApprovalEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(APPROVAL_EVENT, log);
        ApprovalEventResponse typedResponse = new ApprovalEventResponse();
        typedResponse.log = log;
        typedResponse.owner = (String) eventValues.getIndexedValues().get(0).getValue();
        typedResponse.spender = (String) eventValues.getIndexedValues().get(1).getValue();
        typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
        return typedResponse;
    }

    public Flowable<ApprovalEventResponse> approvalEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getApprovalEventFromLog(log));
    }

    public Flowable<ApprovalEventResponse> approvalEventFlowable(DefaultBlockParameter startBlock,
            DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(APPROVAL_EVENT));
        return approvalEventFlowable(filter);
    }

    public static List<OwnershipTransferredEventResponse> getOwnershipTransferredEvents(
            TransactionReceipt transactionReceipt) {
        List<OwnershipTransferredEventResponse> responses = new ArrayList<>();

        // Iterate through each log in the transaction receipt
        for (Log log : transactionReceipt.getLogs()) {
            // Extract event parameters from the log
            Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(OWNERSHIPTRANSFERRED_EVENT, log);
            if (eventValues != null) {
                OwnershipTransferredEventResponse typedResponse = new OwnershipTransferredEventResponse();
                typedResponse.log = eventValues.getLog();
                typedResponse.previousOwner = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.newOwner = (String) eventValues.getIndexedValues().get(1).getValue();
                responses.add(typedResponse);
            }
        }
        return responses;
    }

    public static OwnershipTransferredEventResponse getOwnershipTransferredEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(OWNERSHIPTRANSFERRED_EVENT, log);
        OwnershipTransferredEventResponse typedResponse = new OwnershipTransferredEventResponse();
        typedResponse.log = log;
        typedResponse.previousOwner = (String) eventValues.getIndexedValues().get(0).getValue();
        typedResponse.newOwner = (String) eventValues.getIndexedValues().get(1).getValue();
        return typedResponse;
    }

    public Flowable<OwnershipTransferredEventResponse> ownershipTransferredEventFlowable(
            EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getOwnershipTransferredEventFromLog(log));
    }

    public Flowable<OwnershipTransferredEventResponse> ownershipTransferredEventFlowable(
            DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(OWNERSHIPTRANSFERRED_EVENT));
        return ownershipTransferredEventFlowable(filter);
    }

    public static List<TransferEventResponse> getTransferEvents(
            TransactionReceipt transactionReceipt) {
        List<TransferEventResponse> responses = new ArrayList<>();

        // Iterate through each log in the transaction receipt
        for (Log log : transactionReceipt.getLogs()) {
            // Extract event parameters from the log
            Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(TRANSFER_EVENT, log);
            if (eventValues != null) {
                TransferEventResponse typedResponse = new TransferEventResponse();
                typedResponse.log = eventValues.getLog();
                typedResponse.from = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.to = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                responses.add(typedResponse);
            }
        }
        return responses;
    }

    public static TransferEventResponse getTransferEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(TRANSFER_EVENT, log);
        TransferEventResponse typedResponse = new TransferEventResponse();
        typedResponse.log = log;
        typedResponse.from = (String) eventValues.getIndexedValues().get(0).getValue();
        typedResponse.to = (String) eventValues.getIndexedValues().get(1).getValue();
        typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
        return typedResponse;
    }

    public Flowable<TransferEventResponse> transferEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getTransferEventFromLog(log));
    }

    public Flowable<TransferEventResponse> transferEventFlowable(DefaultBlockParameter startBlock,
            DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(TRANSFER_EVENT));
        return transferEventFlowable(filter);
    }

    public RemoteFunctionCall<BigInteger> allowance(String owner, String spender) {
        final Function function = new Function(FUNC_ALLOWANCE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, owner), 
                new org.web3j.abi.datatypes.Address(160, spender)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> approve(String spender, BigInteger amount) {
        final Function function = new Function(
                FUNC_APPROVE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, spender), 
                new org.web3j.abi.datatypes.generated.Uint256(amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> balanceOf(String account) {
        final Function function = new Function(FUNC_BALANCEOF, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, account)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> charge(String to, BigInteger amount) {
        final Function function = new Function(
                FUNC_CHARGE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, to), 
                new org.web3j.abi.datatypes.generated.Uint256(amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> decimals() {
        final Function function = new Function(FUNC_DECIMALS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> decreaseAllowance(String spender,
            BigInteger subtractedValue) {
        final Function function = new Function(
                FUNC_DECREASEALLOWANCE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, spender), 
                new org.web3j.abi.datatypes.generated.Uint256(subtractedValue)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> increaseAllowance(String spender,
            BigInteger addedValue) {
        final Function function = new Function(
                FUNC_INCREASEALLOWANCE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, spender), 
                new org.web3j.abi.datatypes.generated.Uint256(addedValue)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> name() {
        final Function function = new Function(FUNC_NAME, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> owner() {
        final Function function = new Function(FUNC_OWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> renounceOwnership() {
        final Function function = new Function(
                FUNC_RENOUNCEOWNERSHIP, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> symbol() {
        final Function function = new Function(FUNC_SYMBOL, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<BigInteger> totalSupply() {
        final Function function = new Function(FUNC_TOTALSUPPLY, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> transfer(String to, BigInteger amount) {
        final Function function = new Function(
                FUNC_TRANSFER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, to), 
                new org.web3j.abi.datatypes.generated.Uint256(amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> transferFrom(String from, String to,
            BigInteger amount) {
        final Function function = new Function(
                FUNC_TRANSFERFROM, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, from), 
                new org.web3j.abi.datatypes.Address(160, to), 
                new org.web3j.abi.datatypes.generated.Uint256(amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> transferOwnership(String newOwner) {
        final Function function = new Function(
                FUNC_TRANSFEROWNERSHIP, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, newOwner)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> withdraw(BigInteger amount) {
        final Function function = new Function(
                FUNC_WITHDRAW, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static MyCashToken load(String contractAddress, Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        return new MyCashToken(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static MyCashToken load(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new MyCashToken(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static MyCashToken load(String contractAddress, Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        return new MyCashToken(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static MyCashToken load(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new MyCashToken(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<MyCashToken> deploy(Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider, BigInteger initialSupply) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(initialSupply)));
        return deployRemoteCall(MyCashToken.class, web3j, credentials, contractGasProvider, getDeploymentBinary(), encodedConstructor);
    }

    public static RemoteCall<MyCashToken> deploy(Web3j web3j, TransactionManager transactionManager,
            ContractGasProvider contractGasProvider, BigInteger initialSupply) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(initialSupply)));
        return deployRemoteCall(MyCashToken.class, web3j, transactionManager, contractGasProvider, getDeploymentBinary(), encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<MyCashToken> deploy(Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit, BigInteger initialSupply) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(initialSupply)));
        return deployRemoteCall(MyCashToken.class, web3j, credentials, gasPrice, gasLimit, getDeploymentBinary(), encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<MyCashToken> deploy(Web3j web3j, TransactionManager transactionManager,
            BigInteger gasPrice, BigInteger gasLimit, BigInteger initialSupply) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(initialSupply)));
        return deployRemoteCall(MyCashToken.class, web3j, transactionManager, gasPrice, gasLimit, getDeploymentBinary(), encodedConstructor);
    }

    private static String getDeploymentBinary() {
        if (librariesLinkedBinary != null) {
            return librariesLinkedBinary;
        } else {
            return BINARY;
        }
    }

    public static class ApprovalEventResponse extends BaseEventResponse {
        public String owner;

        public String spender;

        public BigInteger value;
    }

    public static class OwnershipTransferredEventResponse extends BaseEventResponse {
        public String previousOwner;

        public String newOwner;
    }

    public static class TransferEventResponse extends BaseEventResponse {
        public String from;

        public String to;

        public BigInteger value;
    }
}
