if (typeof kotlin === 'undefined') {
  throw new Error("Error loading module 'kotlin-validator'. Its dependency 'kotlin' was not found. Please, check whether 'kotlin' is loaded prior to 'kotlin-validator'.");
}
this['kotlin-validator'] = function (_, Kotlin) {
  'use strict';
  var $$importsForInline$$ = _.$$importsForInline$$ || (_.$$importsForInline$$ = {});
  var Kind_INTERFACE = Kotlin.Kind.INTERFACE;
  var Regex_init = Kotlin.kotlin.text.Regex_init_61zpoe$;
  var Regex_init_0 = Kotlin.kotlin.text.Regex_init_sb3q2$;
  var Regex = Kotlin.kotlin.text.Regex;
  var Kind_CLASS = Kotlin.Kind.CLASS;
  var Annotation = Kotlin.kotlin.Annotation;
  var defineInlineFunction = Kotlin.defineInlineFunction;
  var wrapFunction = Kotlin.wrapFunction;
  var IllegalArgumentException_init = Kotlin.kotlin.IllegalArgumentException_init;
  var IllegalArgumentException = Kotlin.kotlin.IllegalArgumentException;
  var Exception_init = Kotlin.kotlin.Exception_init;
  var Exception = Kotlin.kotlin.Exception;
  var mutableSetOf = Kotlin.kotlin.collections.mutableSetOf_i5x0yv$;
  var toMap = Kotlin.kotlin.collections.toMap_abgq59$;
  var LinkedHashMap_init = Kotlin.kotlin.collections.LinkedHashMap_init_q3lmfv$;
  var Map = Kotlin.kotlin.collections.Map;
  var throwCCE = Kotlin.throwCCE;
  var emptySet = Kotlin.kotlin.collections.emptySet_287e2$;
  var Unit = Kotlin.kotlin.Unit;
  var ArrayList_init = Kotlin.kotlin.collections.ArrayList_init_287e2$;
  var replace = Kotlin.kotlin.text.replace_680rmw$;
  var toString = Kotlin.toString;
  var Kind_OBJECT = Kotlin.Kind.OBJECT;
  var ensureNotNull = Kotlin.ensureNotNull;
  var mutableListOf = Kotlin.kotlin.collections.mutableListOf_i5x0yv$;
  var List = Kotlin.kotlin.collections.List;
  var Collection = Kotlin.kotlin.collections.Collection;
  var isBlank = Kotlin.kotlin.text.isBlank_gw00vp$;
  var equals = Kotlin.equals;
  IllegalOperatorException.prototype = Object.create(IllegalArgumentException.prototype);
  IllegalOperatorException.prototype.constructor = IllegalOperatorException;
  ValidationException.prototype = Object.create(Exception.prototype);
  ValidationException.prototype.constructor = ValidationException;
  function MessageBag() {
  }
  MessageBag.$metadata$ = {
    kind: Kind_INTERFACE,
    simpleName: 'MessageBag',
    interfaces: []
  };
  function Rule() {
  }
  Rule.$metadata$ = {
    kind: Kind_INTERFACE,
    simpleName: 'Rule',
    interfaces: []
  };
  function RuleBuilder() {
  }
  RuleBuilder.prototype.otherwise_61zpoe$ = function (message) {
    this.customMessage_61zpoe$(message);
  };
  RuleBuilder.prototype.invoke_gpb7pm$ = function ($receiver, block) {
    block(this.always_jh3g57$($receiver, new Optional()));
  };
  RuleBuilder.prototype.required_gpb7pm$ = function ($receiver, block) {
    var $receiver_0 = this.always_jh3g57$($receiver, new Required());
    block($receiver_0);
    return $receiver_0;
  };
  RuleBuilder.prototype.required_43xxzu$ = function ($receiver, rule) {
    return this.always_jh3g57$($receiver, new Required()).and_q4ae5d$(rule);
  };
  RuleBuilder.prototype.invoke_ol6fgm$ = function ($receiver, block) {
    block(this.always_qek681$($receiver, new Optional()));
  };
  RuleBuilder.prototype.required_ol6fgm$ = function ($receiver, block) {
    var $receiver_0 = this.always_qek681$($receiver, new Required());
    block($receiver_0);
    return $receiver_0;
  };
  RuleBuilder.prototype.required_tikisq$ = function ($receiver, rule) {
    return this.always_qek681$($receiver, new Required()).and_q4ae5d$(rule);
  };
  RuleBuilder.$metadata$ = {
    kind: Kind_INTERFACE,
    simpleName: 'RuleBuilder',
    interfaces: []
  };
  function Validatable() {
  }
  Validatable.$metadata$ = {
    kind: Kind_INTERFACE,
    simpleName: 'Validatable',
    interfaces: []
  };
  function ValidationResult() {
  }
  ValidationResult.$metadata$ = {
    kind: Kind_INTERFACE,
    simpleName: 'ValidationResult',
    interfaces: []
  };
  function Validator() {
  }
  Validator.prototype.plus_8cw8f8$ = function (validator) {
    return this.extend_8cw8f8$(validator);
  };
  Validator.$metadata$ = {
    kind: Kind_INTERFACE,
    simpleName: 'Validator',
    interfaces: []
  };
  function ValidatorBuilder() {
  }
  ValidatorBuilder.prototype.use_r82fwp$ = function (validator) {
    return this.extend_8cw8f8$(validator);
  };
  ValidatorBuilder.prototype.run_r82fwp$ = function (validator) {
    return this.extend_8cw8f8$(validator);
  };
  ValidatorBuilder.prototype.invoke_gpb7pm$ = function ($receiver, block) {
    block(this.always_jh3g57$($receiver, new Optional()));
  };
  ValidatorBuilder.prototype.required_gpb7pm$ = function ($receiver, block) {
    var $receiver_0 = this.always_jh3g57$($receiver, new Required());
    block($receiver_0);
    return $receiver_0;
  };
  ValidatorBuilder.prototype.required_43xxzu$ = function ($receiver, rule) {
    return this.always_jh3g57$($receiver, new Required()).and_q4ae5d$(rule);
  };
  ValidatorBuilder.prototype.each_ssq3xn$ = function ($receiver, rule) {
    return this.always_jh3g57$($receiver, new Optional()).and_q4ae5d$(new Each(rule));
  };
  ValidatorBuilder.prototype.invoke_ol6fgm$ = function ($receiver, block) {
    block(this.always_qek681$($receiver, new Optional()));
  };
  ValidatorBuilder.prototype.required_ol6fgm$ = function ($receiver, block) {
    var $receiver_0 = this.always_qek681$($receiver, new Required());
    block($receiver_0);
    return $receiver_0;
  };
  ValidatorBuilder.prototype.required_tikisq$ = function ($receiver, rule) {
    return this.always_qek681$($receiver, new Required()).and_q4ae5d$(rule);
  };
  ValidatorBuilder.prototype.each_65y4br$ = function ($receiver, rule) {
    return this.always_qek681$($receiver, new Optional()).and_q4ae5d$(new Each(rule));
  };
  Object.defineProperty(ValidatorBuilder.prototype, 'exists', {
    get: function () {
      return RuleFactory_getInstance().notNull;
    }
  });
  Object.defineProperty(ValidatorBuilder.prototype, 'required', {
    get: function () {
      return RuleFactory_getInstance().required;
    }
  });
  Object.defineProperty(ValidatorBuilder.prototype, 'notNull', {
    get: function () {
      return RuleFactory_getInstance().notNull;
    }
  });
  Object.defineProperty(ValidatorBuilder.prototype, 'notEmptyString', {
    get: function () {
      return RuleFactory_getInstance().notEmptyString;
    }
  });
  ValidatorBuilder.prototype.pass_14urrv$ = function (fn) {
    return new Pass(fn);
  };
  ValidatorBuilder.prototype.passes_14urrv$ = function (fn) {
    return this.pass_14urrv$(fn);
  };
  ValidatorBuilder.prototype.eq_atzj8u$ = function (value) {
    return new NumberComparison(OPERATOR_EQUAL, value);
  };
  ValidatorBuilder.prototype.equal_atzj8u$ = function (value) {
    return new NumberComparison(OPERATOR_EQUAL, value);
  };
  ValidatorBuilder.prototype.gt_atzj8u$ = function (min) {
    return new NumberComparison(OPERATOR_GREATER_THAN, min);
  };
  ValidatorBuilder.prototype.greaterThan_atzj8u$ = function (min) {
    return new NumberComparison(OPERATOR_GREATER_THAN, min);
  };
  ValidatorBuilder.prototype.gte_atzj8u$ = function (min) {
    return new NumberComparison(OPERATOR_GREATER_THAN_OR_EQUAL, min);
  };
  ValidatorBuilder.prototype.greaterThanOrEqual_atzj8u$ = function (min) {
    return new NumberComparison(OPERATOR_GREATER_THAN_OR_EQUAL, min);
  };
  ValidatorBuilder.prototype.lt_atzj8u$ = function (max) {
    return new NumberComparison(OPERATOR_LESS_THAN, max);
  };
  ValidatorBuilder.prototype.lessThan_atzj8u$ = function (max) {
    return new NumberComparison(OPERATOR_LESS_THAN, max);
  };
  ValidatorBuilder.prototype.lte_atzj8u$ = function (max) {
    return new NumberComparison(OPERATOR_LESS_THAN_OR_EQUAL, max);
  };
  ValidatorBuilder.prototype.lessThanOrEqual_atzj8u$ = function (max) {
    return new NumberComparison(OPERATOR_LESS_THAN_OR_EQUAL, max);
  };
  ValidatorBuilder.prototype.minLength_za3lpa$ = function (value) {
    return new StringLength(OPERATOR_GREATER_THAN_OR_EQUAL, value);
  };
  ValidatorBuilder.prototype.maxLength_za3lpa$ = function (value) {
    return new StringLength(OPERATOR_LESS_THAN_OR_EQUAL, value);
  };
  ValidatorBuilder.prototype.exactLength_za3lpa$ = function (value) {
    return new StringLength(OPERATOR_LESS_THAN_OR_EQUAL, value);
  };
  ValidatorBuilder.prototype.passRegex_nz2z7i$ = function (pattern) {
    return new PassRegex(Regex_init(pattern));
  };
  ValidatorBuilder.prototype.passRegex_viu7q6$ = function (pattern, option) {
    return new PassRegex(Regex_init_0(pattern, option));
  };
  ValidatorBuilder.prototype.passRegex_9j12k3$ = function (pattern, option) {
    return new PassRegex(new Regex(pattern, option));
  };
  ValidatorBuilder.prototype.matches_nz2z7i$ = function (pattern) {
    return this.passRegex_nz2z7i$(pattern);
  };
  ValidatorBuilder.prototype.matches_viu7q6$ = function (pattern, option) {
    return this.passRegex_viu7q6$(pattern, option);
  };
  ValidatorBuilder.prototype.matches_9j12k3$ = function (pattern, option) {
    return this.passRegex_9j12k3$(pattern, option);
  };
  ValidatorBuilder.prototype.each_yx6dx6$ = function (rule) {
    return new Each(rule);
  };
  ValidatorBuilder.$metadata$ = {
    kind: Kind_INTERFACE,
    simpleName: 'ValidatorBuilder',
    interfaces: []
  };
  function ValidatorBuilderDsl() {
  }
  ValidatorBuilderDsl.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'ValidatorBuilderDsl',
    interfaces: [Annotation]
  };
  function RuleDsl() {
  }
  RuleDsl.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'RuleDsl',
    interfaces: [Annotation]
  };
  function RuleBuilderDsl() {
  }
  RuleBuilderDsl.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'RuleBuilderDsl',
    interfaces: [Annotation]
  };
  function and($receiver, rule) {
    if (Kotlin.isType($receiver, RuleCollectionImpl)) {
      return $receiver.addRule_44p11a$(rule);
    }
    if (Kotlin.isType(rule, RuleCollectionImpl)) {
      return rule.addRule_44p11a$($receiver);
    }
    return (new RuleCollectionImpl(new Optional())).addRule_44p11a$($receiver).addRule_44p11a$(rule);
  }
  function plus($receiver, rule) {
    return and($receiver, rule);
  }
  function validatedBy($receiver, validator) {
    return validator.validate_11rb$($receiver);
  }
  function validate($receiver, block) {
    return (new ValidatorImpl(block)).validate_11rb$($receiver);
  }
  function assert($receiver, validator) {
    var result = validator.validate_11rb$($receiver);
    if (!result.isValid) {
      throw new ValidationException(result.errors);
    }
    return $receiver;
  }
  function assert_0($receiver, block) {
    var result = (new ValidatorImpl(block)).validate_11rb$($receiver);
    if (!result.isValid) {
      throw new ValidationException(result.errors);
    }
    return $receiver;
  }
  var maxSize = defineInlineFunction('kotlin-validator.net.ntworld.kotlin.validator.maxSize_quudc7$', wrapFunction(function () {
    var ArraySize = _.net.ntworld.kotlin.validator.rule.ArraySize;
    var validator = _.net.ntworld.kotlin.validator;
    return function (T_0, isT, $receiver, value) {
      return new ArraySize(validator.OPERATOR_LESS_THAN_OR_EQUAL, value);
    };
  }));
  var minSize = defineInlineFunction('kotlin-validator.net.ntworld.kotlin.validator.minSize_quudc7$', wrapFunction(function () {
    var ArraySize = _.net.ntworld.kotlin.validator.rule.ArraySize;
    var validator = _.net.ntworld.kotlin.validator;
    return function (T_0, isT, $receiver, value) {
      return new ArraySize(validator.OPERATOR_GREATER_THAN_OR_EQUAL, value);
    };
  }));
  var exactSize = defineInlineFunction('kotlin-validator.net.ntworld.kotlin.validator.exactSize_quudc7$', wrapFunction(function () {
    var ArraySize = _.net.ntworld.kotlin.validator.rule.ArraySize;
    var validator = _.net.ntworld.kotlin.validator;
    return function (T_0, isT, $receiver, value) {
      return new ArraySize(validator.OPERATOR_EQUAL, value);
    };
  }));
  var MESSAGE_OPTIONAL;
  var MESSAGE_REQUIRED;
  var MESSAGE_NOT_NULL;
  var MESSAGE_NESTED_VALIDATOR;
  var MESSAGE_PASS;
  var MESSAGE_REGEX;
  var MESSAGE_EACH;
  var MESSAGE_NOT_EMPTY_STRING;
  var MESSAGE_NUMBER_EQUAL;
  var MESSAGE_NUMBER_GREATER_THAN;
  var MESSAGE_NUMBER_GREATER_THAN_OR_EQUAL;
  var MESSAGE_NUMBER_LESS_THAN;
  var MESSAGE_NUMBER_LESS_THAN_OR_EQUAL;
  var MESSAGE_STRING_LENGTH_EQUAL;
  var MESSAGE_STRING_LENGTH_GREATER_THAN;
  var MESSAGE_STRING_LENGTH_GREATER_THAN_OR_EQUAL;
  var MESSAGE_STRING_LENGTH_LESS_THAN;
  var MESSAGE_STRING_LENGTH_LESS_THAN_OR_EQUAL;
  var MESSAGE_ARRAY_SIZE_EQUAL;
  var MESSAGE_ARRAY_SIZE_GREATER_THAN;
  var MESSAGE_ARRAY_SIZE_GREATER_THAN_OR_EQUAL;
  var MESSAGE_ARRAY_SIZE_LESS_THAN;
  var MESSAGE_ARRAY_SIZE_LESS_THAN_OR_EQUAL;
  var OPERATOR_EQUAL;
  var OPERATOR_GREATER_THAN;
  var OPERATOR_GREATER_THAN_OR_EQUAL;
  var OPERATOR_LESS_THAN;
  var OPERATOR_LESS_THAN_OR_EQUAL;
  function validator(block) {
    return new ValidatorImpl(block);
  }
  function validate_0(input, block) {
    return (new ValidatorImpl(block)).validate_11rb$(input);
  }
  function assertValid(input, block) {
    var result = validate_0(input, block);
    if (!result.isValid) {
      throw new ValidationException(result.errors);
    }
  }
  function IllegalOperatorException() {
    IllegalArgumentException_init(this);
    this.name = 'IllegalOperatorException';
  }
  IllegalOperatorException.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'IllegalOperatorException',
    interfaces: [IllegalArgumentException]
  };
  function ValidationException(errors) {
    Exception_init(this);
    this.errors = errors;
    this.name = 'ValidationException';
  }
  ValidationException.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'ValidationException',
    interfaces: [Exception]
  };
  function MessageBagImpl() {
    this.messages_0 = LinkedHashMap_init();
  }
  MessageBagImpl.prototype.clear = function () {
    this.messages_0.clear();
    return this;
  };
  MessageBagImpl.prototype.keys = function () {
    return this.messages_0.keys;
  };
  MessageBagImpl.prototype.has_61zpoe$ = function (key) {
    var $receiver = this.messages_0;
    var tmp$;
    return (Kotlin.isType(tmp$ = $receiver, Map) ? tmp$ : throwCCE()).containsKey_11rb$(key);
  };
  MessageBagImpl.prototype.get_61zpoe$ = function (key) {
    var result = this.messages_0.get_11rb$(key);
    return result != null ? result : emptySet();
  };
  MessageBagImpl.prototype.add_puj7f4$ = function (key, message) {
    var bag = this.messages_0.get_11rb$(key);
    if (bag === null) {
      var newBag = mutableSetOf([message]);
      this.messages_0.put_xwzc9p$(key, newBag);
      return this;
    }
    bag.add_11rb$(message);
    return this;
  };
  MessageBagImpl.prototype.remove_puj7f4$ = function (key, message) {
    var bag = this.messages_0.get_11rb$(key);
    if (bag === null) {
      return this;
    }
    bag.remove_11rb$(message);
    if (bag.isEmpty()) {
      this.messages_0.remove_11rb$(key);
    }
    return this;
  };
  MessageBagImpl.prototype.toMap = function () {
    return toMap(this.messages_0);
  };
  MessageBagImpl.prototype.isEmpty = function () {
    return this.messages_0.isEmpty();
  };
  MessageBagImpl.prototype.isNotEmpty = function () {
    return !this.messages_0.isEmpty();
  };
  MessageBagImpl.prototype.copyFrom_0 = function (bag) {
    var tmp$, tmp$_0;
    var source = bag.toMap().entries;
    tmp$ = source.iterator();
    while (tmp$.hasNext()) {
      var entry = tmp$.next();
      tmp$_0 = entry.value.iterator();
      while (tmp$_0.hasNext()) {
        var message = tmp$_0.next();
        this.add_puj7f4$(entry.key, message);
      }
    }
  };
  MessageBagImpl.prototype.plus_p333o7$ = function (bag) {
    var result = new MessageBagImpl();
    result.copyFrom_0(this);
    result.copyFrom_0(bag);
    return result;
  };
  MessageBagImpl.prototype.plusAssign_p333o7$ = function (bag) {
    this.copyFrom_0(bag);
  };
  MessageBagImpl.prototype.toString = function () {
    return this.messages_0.toString();
  };
  MessageBagImpl.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'MessageBagImpl',
    interfaces: [MessageBag]
  };
  function RuleBuilderImpl(started) {
    this.ruleCollection_8be2vx$ = new RuleCollectionImpl(started);
  }
  Object.defineProperty(RuleBuilderImpl.prototype, 'rule', {
    get: function () {
      return this.ruleCollection_8be2vx$;
    },
    set: function (value) {
      this.ruleCollection_8be2vx$.addRule_44p11a$(value);
    }
  });
  Object.defineProperty(RuleBuilderImpl.prototype, 'message', {
    get: function () {
      return this.ruleCollection_8be2vx$.message;
    },
    set: function (value) {
      this.ruleCollection_8be2vx$.customMessage_8be2vx$ = value;
    }
  });
  RuleBuilderImpl.prototype.and_q4ae5d$ = function (rule) {
    this.ruleCollection_8be2vx$.addRule_44p11a$(rule);
    return this;
  };
  RuleBuilderImpl.prototype.customMessage_61zpoe$ = function (message) {
    this.message = message;
  };
  function RuleBuilderImpl$always$lambda($receiver) {
    return Unit;
  }
  RuleBuilderImpl.prototype.always_jh3g57$ = function ($receiver, rule) {
    var validator = new ValidatorImpl(RuleBuilderImpl$always$lambda);
    var builder = new RuleBuilderImpl(rule);
    validator.registerProperty_3h5okr$($receiver, builder.ruleCollection_8be2vx$);
    this.ruleCollection_8be2vx$.addRule_44p11a$(validator);
    return builder;
  };
  function RuleBuilderImpl$always$lambda_0($receiver) {
    return Unit;
  }
  RuleBuilderImpl.prototype.always_qek681$ = function ($receiver, rule) {
    var validator = new ValidatorImpl(RuleBuilderImpl$always$lambda_0);
    var builder = new RuleBuilderImpl(rule);
    validator.registerProperty_sp4my7$($receiver, builder.ruleCollection_8be2vx$);
    this.ruleCollection_8be2vx$.addRule_44p11a$(validator);
    return builder;
  };
  RuleBuilderImpl.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'RuleBuilderImpl',
    interfaces: [RuleBuilder]
  };
  function RuleCollectionImpl(started, customMessage) {
    if (customMessage === void 0)
      customMessage = null;
    this.customMessage_8be2vx$ = customMessage;
    this.collection_8be2vx$ = ArrayList_init();
    this.startedRule_0 = new RuleExecutor(started);
  }
  Object.defineProperty(RuleCollectionImpl.prototype, 'message', {
    get: function () {
      var tmp$;
      return (tmp$ = this.customMessage_8be2vx$) != null ? tmp$ : '';
    }
  });
  RuleCollectionImpl.prototype.passes_yuqcw7$ = function (attribute, value) {
    var startedValid = this.startedRule_0.passes_yuqcw7$(attribute, value);
    var tmp$;
    var accumulator = true;
    tmp$ = this.collection_8be2vx$.iterator();
    while (tmp$.hasNext()) {
      var element = tmp$.next();
      var acc = accumulator;
      accumulator = (element.passes_yuqcw7$(attribute, value) && acc);
    }
    var valid = accumulator;
    return startedValid && valid;
  };
  RuleCollectionImpl.prototype.buildErrorMessages_y27m3r$ = function (errors, attribute, value) {
    if (this.message.length > 0) {
      RuleExecutor$Companion_getInstance().addMessageToBagIfNeeded_kksvm7$(errors, this.message, attribute, value);
      return;
    }
    if (!this.startedRule_0.isValid_8be2vx$) {
      return this.startedRule_0.buildErrorMessages_gb73do$(errors, attribute, value);
    }
    var tmp$;
    tmp$ = this.collection_8be2vx$.iterator();
    while (tmp$.hasNext()) {
      var element = tmp$.next();
      element.buildErrorMessages_gb73do$(errors, attribute, value);
    }
  };
  RuleCollectionImpl.prototype.addRule_44p11a$ = function (rule) {
    if (Kotlin.isType(rule, RuleCollectionImpl)) {
      this.collection_8be2vx$.addAll_brywnq$(rule.collection_8be2vx$);
    }
     else {
      this.collection_8be2vx$.add_11rb$(new RuleExecutor(rule));
    }
    return this;
  };
  RuleCollectionImpl.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'RuleCollectionImpl',
    interfaces: [Rule]
  };
  function RuleExecutor(rule) {
    RuleExecutor$Companion_getInstance();
    this.rule_0 = rule;
    this.isValid_8be2vx$ = false;
    this.message_pcwbiv$_0 = this.rule_0.message;
  }
  Object.defineProperty(RuleExecutor.prototype, 'message', {
    get: function () {
      return this.message_pcwbiv$_0;
    }
  });
  RuleExecutor.prototype.passes_yuqcw7$ = function (attribute, value) {
    this.isValid_8be2vx$ = this.rule_0.passes_yuqcw7$(attribute, value);
    return this.isValid_8be2vx$;
  };
  RuleExecutor.prototype.buildErrorMessages_gb73do$ = function (errors, attribute, value) {
    if (this.isValid_8be2vx$) {
      return;
    }
    if (Kotlin.isType(this.rule_0, ValidatorImpl)) {
      this.rule_0.buildErrorMessages_y27m3r$(errors, attribute, value);
    }
    RuleExecutor$Companion_getInstance().addMessageToBagIfNeeded_kksvm7$(errors, this.message, attribute, value);
  };
  function RuleExecutor$Companion() {
    RuleExecutor$Companion_instance = this;
  }
  RuleExecutor$Companion.prototype.formatMessage_tweco7$ = function (message, attribute, value) {
    return replace(replace(replace(replace(replace(replace(message, ':attribute', attribute), '[attribute]', attribute), '{attribute}', attribute), ':value', toString(value)), '[value]', toString(value)), '{value}', toString(value));
  };
  RuleExecutor$Companion.prototype.addMessageToBagIfNeeded_kksvm7$ = function (bag, message, attribute, value) {
    var formattedMessage = this.formatMessage_tweco7$(message, attribute, value);
    if (formattedMessage.length > 0) {
      bag.add_puj7f4$(attribute, formattedMessage);
    }
  };
  RuleExecutor$Companion.$metadata$ = {
    kind: Kind_OBJECT,
    simpleName: 'Companion',
    interfaces: []
  };
  var RuleExecutor$Companion_instance = null;
  function RuleExecutor$Companion_getInstance() {
    if (RuleExecutor$Companion_instance === null) {
      new RuleExecutor$Companion();
    }
    return RuleExecutor$Companion_instance;
  }
  RuleExecutor.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'RuleExecutor',
    interfaces: [Rule]
  };
  function RuleFactory() {
    RuleFactory_instance = this;
    this.notNull = new NotNull();
    this.required = new Required();
    this.notEmptyString = new NotEmptyString();
  }
  RuleFactory.$metadata$ = {
    kind: Kind_OBJECT,
    simpleName: 'RuleFactory',
    interfaces: []
  };
  var RuleFactory_instance = null;
  function RuleFactory_getInstance() {
    if (RuleFactory_instance === null) {
      new RuleFactory();
    }
    return RuleFactory_instance;
  }
  function ValidationResultImpl(isValid, errors) {
    this.isValid_a8ejxh$_0 = isValid;
    this.errors_abivn6$_0 = errors;
  }
  Object.defineProperty(ValidationResultImpl.prototype, 'isValid', {
    get: function () {
      return this.isValid_a8ejxh$_0;
    }
  });
  Object.defineProperty(ValidationResultImpl.prototype, 'errors', {
    get: function () {
      return this.errors_abivn6$_0;
    }
  });
  ValidationResultImpl.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'ValidationResultImpl',
    interfaces: [ValidationResult]
  };
  ValidationResultImpl.prototype.component1 = function () {
    return this.isValid;
  };
  ValidationResultImpl.prototype.component2 = function () {
    return this.errors;
  };
  ValidationResultImpl.prototype.copy_kr26gq$ = function (isValid, errors) {
    return new ValidationResultImpl(isValid === void 0 ? this.isValid : isValid, errors === void 0 ? this.errors : errors);
  };
  ValidationResultImpl.prototype.toString = function () {
    return 'ValidationResultImpl(isValid=' + Kotlin.toString(this.isValid) + (', errors=' + Kotlin.toString(this.errors)) + ')';
  };
  ValidationResultImpl.prototype.hashCode = function () {
    var result = 0;
    result = result * 31 + Kotlin.hashCode(this.isValid) | 0;
    result = result * 31 + Kotlin.hashCode(this.errors) | 0;
    return result;
  };
  ValidationResultImpl.prototype.equals = function (other) {
    return this === other || (other !== null && (typeof other === 'object' && (Object.getPrototypeOf(this) === Object.getPrototypeOf(other) && (Kotlin.equals(this.isValid, other.isValid) && Kotlin.equals(this.errors, other.errors)))));
  };
  function ValidatorBuilderImpl(validator) {
    this.validator_0 = validator;
  }
  ValidatorBuilderImpl.prototype.extend_8cw8f8$ = function (validator) {
    this.validator_0.extend_8cw8f8$(validator);
    return this;
  };
  ValidatorBuilderImpl.prototype.always_jh3g57$ = function ($receiver, rule) {
    var builder = new RuleBuilderImpl(rule);
    this.validator_0.registerProperty_3h5okr$($receiver, builder.ruleCollection_8be2vx$);
    return builder;
  };
  ValidatorBuilderImpl.prototype.always_qek681$ = function ($receiver, rule) {
    var builder = new RuleBuilderImpl(rule);
    this.validator_0.registerProperty_sp4my7$($receiver, builder.ruleCollection_8be2vx$);
    return builder;
  };
  ValidatorBuilderImpl.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'ValidatorBuilderImpl',
    interfaces: [ValidatorBuilder]
  };
  function ValidatorImpl(block) {
    this.message_yco31m$_0 = MESSAGE_NESTED_VALIDATOR;
    this.data_0 = LinkedHashMap_init();
    block(new ValidatorBuilderImpl(this));
  }
  Object.defineProperty(ValidatorImpl.prototype, 'message', {
    get: function () {
      return this.message_yco31m$_0;
    }
  });
  ValidatorImpl.prototype.passes_yuqcw7$ = function (attribute, value) {
    if (null !== value) {
      return this.validate_11rb$(value).isValid;
    }
    return true;
  };
  ValidatorImpl.prototype.buildErrorMessages_y27m3r$ = function (errors, attribute, value) {
    var tmp$;
    tmp$ = this.data_0.entries.iterator();
    while (tmp$.hasNext()) {
      var element = tmp$.next();
      element.value.buildErrorMessages_ys7zgn$(errors, attribute + '.' + element.key, element.key, ensureNotNull(value));
    }
  };
  ValidatorImpl.prototype.registerProperty_3h5okr$ = function (property, rules) {
    var tmp$;
    var key = property.callableName;
    if (!this.data_0.containsKey_11rb$(key)) {
      var $receiver = this.data_0;
      var value = new ValidatorItem(property, null, mutableListOf([rules]));
      $receiver.put_xwzc9p$(key, value);
      return;
    }
    var item = Kotlin.isType(tmp$ = this.data_0.get_11rb$(key), ValidatorItem) ? tmp$ : throwCCE();
    item.list.add_11rb$(rules);
  };
  ValidatorImpl.prototype.registerProperty_sp4my7$ = function (property, rules) {
    var tmp$;
    var key = property.callableName;
    if (!this.data_0.containsKey_11rb$(key)) {
      var $receiver = this.data_0;
      var value = new ValidatorItem(null, property, mutableListOf([rules]));
      $receiver.put_xwzc9p$(key, value);
      return;
    }
    var item = Kotlin.isType(tmp$ = this.data_0.get_11rb$(key), ValidatorItem) ? tmp$ : throwCCE();
    item.list.add_11rb$(rules);
  };
  ValidatorImpl.prototype.extend_8cw8f8$ = function (validator) {
    var tmp$, tmp$_0;
    if (Kotlin.isType(validator, ValidatorImpl)) {
      tmp$ = validator.data_0.entries.iterator();
      while (tmp$.hasNext()) {
        var entry = tmp$.next();
        var key = entry.key;
        var item = entry.value;
        if (!this.data_0.containsKey_11rb$(key)) {
          this.data_0.put_xwzc9p$(key, item);
          continue;
        }
        (Kotlin.isType(tmp$_0 = this.data_0.get_11rb$(key), ValidatorItem) ? tmp$_0 : throwCCE()).merge_f1tbej$(item);
      }
    }
    return this;
  };
  ValidatorImpl.prototype.validate_11rb$ = function (input) {
    var errors = new MessageBagImpl();
    var tmp$;
    var accumulator = true;
    tmp$ = this.data_0.entries.iterator();
    while (tmp$.hasNext()) {
      var element = tmp$.next();
      var acc = accumulator;
      accumulator = (element.value.validate_bqz1pj$(element.key, input, errors) && acc);
    }
    var valid = accumulator;
    return new ValidationResultImpl(valid, errors);
  };
  ValidatorImpl.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'ValidatorImpl',
    interfaces: [Validator, Rule]
  };
  function ValidatorItem(property0, property1, list) {
    this.property0 = property0;
    this.property1 = property1;
    this.list = list;
  }
  ValidatorItem.prototype.validate_bqz1pj$ = function (attribute, input, errors) {
    var value = this.getValue_0(attribute, input);
    var tmp$;
    var accumulator = true;
    tmp$ = this.list.iterator();
    while (tmp$.hasNext()) {
      var element = tmp$.next();
      var acc = accumulator;
      var valid = element.passes_yuqcw7$(attribute, value);
      if (!valid) {
        element.buildErrorMessages_y27m3r$(errors, attribute, value);
      }
      accumulator = (valid && acc);
    }
    return accumulator;
  };
  ValidatorItem.prototype.buildErrorMessages_ys7zgn$ = function (errors, attributeDisplayed, attribute, input) {
    var tmp$;
    tmp$ = this.list.iterator();
    while (tmp$.hasNext()) {
      var element = tmp$.next();
      element.buildErrorMessages_y27m3r$(errors, attributeDisplayed, this.getValue_0(attribute, input));
    }
  };
  ValidatorItem.prototype.merge_f1tbej$ = function (item) {
    var tmp$;
    this.list.addAll_brywnq$(Kotlin.isType(tmp$ = item.list, List) ? tmp$ : throwCCE());
  };
  ValidatorItem.prototype.validateRules_0 = function (rules, attribute, value) {
    return rules.passes_yuqcw7$(attribute, value);
  };
  ValidatorItem.prototype.getValue_0 = function (attribute, input) {
    if (Kotlin.isType(input, Validatable)) {
      if (input.containsKey_61zpoe$(attribute)) {
        return this.getValidationItemValue_0(input);
      }
      return null;
    }
     else
      return this.getValidationItemValue_0(input);
  };
  ValidatorItem.prototype.getValidationItemValue_0 = function (input) {
    if (null !== this.property0) {
      return this.property0.get();
    }
    return ensureNotNull(this.property1).get(input);
  };
  ValidatorItem.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'ValidatorItem',
    interfaces: []
  };
  function ArraySize(operator, value) {
    ArraySize$Companion_getInstance();
    this.operator_0 = operator;
    this.value_0 = value;
  }
  Object.defineProperty(ArraySize.prototype, 'message', {
    get: function () {
      var tmp$;
      switch (this.operator_0) {
        case 'eq':
          tmp$ = this.fillMessage_0(MESSAGE_ARRAY_SIZE_EQUAL, this.value_0);
          break;
        case 'gt':
          tmp$ = this.fillMessage_0(MESSAGE_ARRAY_SIZE_GREATER_THAN, this.value_0);
          break;
        case 'gte':
          tmp$ = this.fillMessage_0(MESSAGE_ARRAY_SIZE_GREATER_THAN_OR_EQUAL, this.value_0);
          break;
        case 'lt':
          tmp$ = this.fillMessage_0(MESSAGE_ARRAY_SIZE_LESS_THAN, this.value_0);
          break;
        case 'lte':
          tmp$ = this.fillMessage_0(MESSAGE_ARRAY_SIZE_LESS_THAN_OR_EQUAL, this.value_0);
          break;
        default:throw new IllegalOperatorException();
      }
      return tmp$;
    }
  });
  ArraySize.prototype.passes_yuqcw7$ = function (attribute, value) {
    var tmp$;
    if (value == null)
      tmp$ = this.runPasses_0(0);
    else if (typeof value === 'string')
      tmp$ = this.runPasses_0(value.length);
    else if (Kotlin.isType(value, Collection))
      tmp$ = this.runPasses_0(value.size);
    else if (Kotlin.isType(value, Map))
      tmp$ = this.runPasses_0(value.size);
    else if (Kotlin.isArray(value))
      tmp$ = this.runPasses_0(value.length);
    else if (Kotlin.isBooleanArray(value))
      tmp$ = this.runPasses_0(value.length);
    else if (Kotlin.isByteArray(value))
      tmp$ = this.runPasses_0(value.length);
    else if (Kotlin.isShortArray(value))
      tmp$ = this.runPasses_0(value.length);
    else if (Kotlin.isIntArray(value))
      tmp$ = this.runPasses_0(value.length);
    else if (Kotlin.isLongArray(value))
      tmp$ = this.runPasses_0(value.length);
    else if (Kotlin.isFloatArray(value))
      tmp$ = this.runPasses_0(value.length);
    else if (Kotlin.isDoubleArray(value))
      tmp$ = this.runPasses_0(value.length);
    else if (Kotlin.isCharArray(value))
      tmp$ = this.runPasses_0(value.length);
    else
      throw new IllegalOperatorException();
    return tmp$;
  };
  ArraySize.prototype.runPasses_0 = function (size) {
    var tmp$;
    switch (this.operator_0) {
      case 'eq':
        tmp$ = size === this.value_0;
        break;
      case 'gt':
        tmp$ = size > this.value_0;
        break;
      case 'gte':
        tmp$ = size >= this.value_0;
        break;
      case 'lt':
        tmp$ = size < this.value_0;
        break;
      case 'lte':
        tmp$ = size <= this.value_0;
        break;
      default:tmp$ = false;
        break;
    }
    return tmp$;
  };
  ArraySize.prototype.fillMessage_0 = function (message, value) {
    return replace(message, '{size}', value.toString());
  };
  function ArraySize$Companion() {
    ArraySize$Companion_instance = this;
  }
  ArraySize$Companion.prototype.eq_ww73n8$ = defineInlineFunction('kotlin-validator.net.ntworld.kotlin.validator.rule.ArraySize.Companion.eq_ww73n8$', wrapFunction(function () {
    var validator = _.net.ntworld.kotlin.validator;
    var ArraySize_init = _.net.ntworld.kotlin.validator.rule.ArraySize;
    return function (T_0, isT, value) {
      return new ArraySize_init(validator.OPERATOR_EQUAL, value);
    };
  }));
  ArraySize$Companion.prototype.gt_ww73n8$ = defineInlineFunction('kotlin-validator.net.ntworld.kotlin.validator.rule.ArraySize.Companion.gt_ww73n8$', wrapFunction(function () {
    var validator = _.net.ntworld.kotlin.validator;
    var ArraySize_init = _.net.ntworld.kotlin.validator.rule.ArraySize;
    return function (T_0, isT, value) {
      return new ArraySize_init(validator.OPERATOR_GREATER_THAN, value);
    };
  }));
  ArraySize$Companion.prototype.gte_ww73n8$ = defineInlineFunction('kotlin-validator.net.ntworld.kotlin.validator.rule.ArraySize.Companion.gte_ww73n8$', wrapFunction(function () {
    var validator = _.net.ntworld.kotlin.validator;
    var ArraySize_init = _.net.ntworld.kotlin.validator.rule.ArraySize;
    return function (T_0, isT, value) {
      return new ArraySize_init(validator.OPERATOR_GREATER_THAN_OR_EQUAL, value);
    };
  }));
  ArraySize$Companion.prototype.lt_ww73n8$ = defineInlineFunction('kotlin-validator.net.ntworld.kotlin.validator.rule.ArraySize.Companion.lt_ww73n8$', wrapFunction(function () {
    var validator = _.net.ntworld.kotlin.validator;
    var ArraySize_init = _.net.ntworld.kotlin.validator.rule.ArraySize;
    return function (T_0, isT, value) {
      return new ArraySize_init(validator.OPERATOR_LESS_THAN, value);
    };
  }));
  ArraySize$Companion.prototype.lte_ww73n8$ = defineInlineFunction('kotlin-validator.net.ntworld.kotlin.validator.rule.ArraySize.Companion.lte_ww73n8$', wrapFunction(function () {
    var validator = _.net.ntworld.kotlin.validator;
    var ArraySize_init = _.net.ntworld.kotlin.validator.rule.ArraySize;
    return function (T_0, isT, value) {
      return new ArraySize_init(validator.OPERATOR_LESS_THAN_OR_EQUAL, value);
    };
  }));
  ArraySize$Companion.$metadata$ = {
    kind: Kind_OBJECT,
    simpleName: 'Companion',
    interfaces: []
  };
  var ArraySize$Companion_instance = null;
  function ArraySize$Companion_getInstance() {
    if (ArraySize$Companion_instance === null) {
      new ArraySize$Companion();
    }
    return ArraySize$Companion_instance;
  }
  ArraySize.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'ArraySize',
    interfaces: [Rule]
  };
  function Each(rule) {
    this.rule_0 = rule;
    this.message_5sg610$_0 = MESSAGE_EACH;
  }
  Object.defineProperty(Each.prototype, 'message', {
    get: function () {
      return this.message_5sg610$_0;
    }
  });
  Each.prototype.passes_yuqcw7$ = function (attribute, value) {
    if (null !== value) {
      var tmp$;
      var accumulator = true;
      tmp$ = value.iterator();
      while (tmp$.hasNext()) {
        var element = tmp$.next();
        return accumulator && this.rule_0.passes_yuqcw7$(attribute, element);
      }
      return accumulator;
    }
    return true;
  };
  Each.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'Each',
    interfaces: [Rule]
  };
  function NotEmptyString() {
    this.message_ai04be$_0 = MESSAGE_NOT_EMPTY_STRING;
  }
  Object.defineProperty(NotEmptyString.prototype, 'message', {
    get: function () {
      return this.message_ai04be$_0;
    }
  });
  NotEmptyString.prototype.passes_yuqcw7$ = function (attribute, value) {
    return !(value == null || isBlank(value));
  };
  NotEmptyString.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'NotEmptyString',
    interfaces: [Rule]
  };
  function NotNull() {
    this.message_atc4yl$_0 = MESSAGE_NOT_NULL;
  }
  Object.defineProperty(NotNull.prototype, 'message', {
    get: function () {
      return this.message_atc4yl$_0;
    }
  });
  NotNull.prototype.passes_yuqcw7$ = function (attribute, value) {
    return null !== value;
  };
  NotNull.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'NotNull',
    interfaces: [Rule]
  };
  function NumberComparison(operator, value) {
    this.operator_0 = operator;
    this.value_0 = value;
  }
  Object.defineProperty(NumberComparison.prototype, 'message', {
    get: function () {
      var tmp$;
      switch (this.operator_0) {
        case 'eq':
          tmp$ = this.fillMessage_0(MESSAGE_NUMBER_EQUAL, this.value_0);
          break;
        case 'gt':
          tmp$ = this.fillMessage_0(MESSAGE_NUMBER_GREATER_THAN, this.value_0);
          break;
        case 'gte':
          tmp$ = this.fillMessage_0(MESSAGE_NUMBER_GREATER_THAN_OR_EQUAL, this.value_0);
          break;
        case 'lt':
          tmp$ = this.fillMessage_0(MESSAGE_NUMBER_LESS_THAN, this.value_0);
          break;
        case 'lte':
          tmp$ = this.fillMessage_0(MESSAGE_NUMBER_LESS_THAN_OR_EQUAL, this.value_0);
          break;
        default:throw new IllegalOperatorException();
      }
      return tmp$;
    }
  });
  NumberComparison.prototype.passes_yuqcw7$ = function (attribute, value) {
    var tmp$;
    if (null !== value) {
      switch (this.operator_0) {
        case 'eq':
          tmp$ = equals(value, this.value_0);
          break;
        case 'gt':
          tmp$ = Kotlin.compareTo(value, this.value_0) > 0;
          break;
        case 'gte':
          tmp$ = Kotlin.compareTo(value, this.value_0) >= 0;
          break;
        case 'lt':
          tmp$ = Kotlin.compareTo(value, this.value_0) < 0;
          break;
        case 'lte':
          tmp$ = Kotlin.compareTo(value, this.value_0) <= 0;
          break;
        default:throw new IllegalOperatorException();
      }
      return tmp$;
    }
    return false;
  };
  NumberComparison.prototype.fillMessage_0 = function (message, value) {
    return replace(message, '{value}', value.toString());
  };
  NumberComparison.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'NumberComparison',
    interfaces: [Rule]
  };
  function Optional() {
    this.message_smmjgl$_0 = MESSAGE_OPTIONAL;
  }
  Object.defineProperty(Optional.prototype, 'message', {
    get: function () {
      return this.message_smmjgl$_0;
    }
  });
  Optional.prototype.passes_yuqcw7$ = function (attribute, value) {
    return true;
  };
  Optional.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'Optional',
    interfaces: [Rule]
  };
  function Pass(fn) {
    this.fn_0 = fn;
    this.message_9f3f5g$_0 = MESSAGE_PASS;
  }
  Object.defineProperty(Pass.prototype, 'message', {
    get: function () {
      return this.message_9f3f5g$_0;
    }
  });
  Pass.prototype.passes_yuqcw7$ = function (attribute, value) {
    return this.fn_0(value);
  };
  Pass.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'Pass',
    interfaces: [Rule]
  };
  function PassRegex(regex) {
    this.regex_0 = regex;
    this.message_f7s195$_0 = MESSAGE_REGEX;
  }
  Object.defineProperty(PassRegex.prototype, 'message', {
    get: function () {
      return this.message_f7s195$_0;
    }
  });
  PassRegex.prototype.passes_yuqcw7$ = function (attribute, value) {
    if (value !== null) {
      return this.regex_0.matches_6bul2c$(value);
    }
    return false;
  };
  PassRegex.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'PassRegex',
    interfaces: [Rule]
  };
  function Required() {
    this.message_tbwply$_0 = MESSAGE_REQUIRED;
  }
  Object.defineProperty(Required.prototype, 'message', {
    get: function () {
      return this.message_tbwply$_0;
    }
  });
  Required.prototype.passes_yuqcw7$ = function (attribute, value) {
    if (value == null)
      return false;
    else if (typeof value === 'string') {
      return value.length > 0;
    }
     else if (Kotlin.isType(value, Collection)) {
      return !value.isEmpty();
    }
     else if (Kotlin.isType(value, Map)) {
      return !value.isEmpty();
    }
     else if (Kotlin.isArray(value)) {
      return !(value.length === 0);
    }
     else if (Kotlin.isBooleanArray(value)) {
      return !(value.length === 0);
    }
     else if (Kotlin.isByteArray(value)) {
      return !(value.length === 0);
    }
     else if (Kotlin.isShortArray(value)) {
      return !(value.length === 0);
    }
     else if (Kotlin.isIntArray(value)) {
      return !(value.length === 0);
    }
     else if (Kotlin.isLongArray(value)) {
      return !(value.length === 0);
    }
     else if (Kotlin.isFloatArray(value)) {
      return !(value.length === 0);
    }
     else if (Kotlin.isDoubleArray(value)) {
      return !(value.length === 0);
    }
     else if (Kotlin.isCharArray(value)) {
      return !(value.length === 0);
    }
    return true;
  };
  Required.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'Required',
    interfaces: [Rule]
  };
  function StringLength(operator, value) {
    this.operator_0 = operator;
    this.value_0 = value;
  }
  Object.defineProperty(StringLength.prototype, 'message', {
    get: function () {
      var tmp$;
      switch (this.operator_0) {
        case 'eq':
          tmp$ = this.fillMessage_0(MESSAGE_STRING_LENGTH_EQUAL, this.value_0);
          break;
        case 'gt':
          tmp$ = this.fillMessage_0(MESSAGE_STRING_LENGTH_GREATER_THAN, this.value_0);
          break;
        case 'gte':
          tmp$ = this.fillMessage_0(MESSAGE_STRING_LENGTH_GREATER_THAN_OR_EQUAL, this.value_0);
          break;
        case 'lt':
          tmp$ = this.fillMessage_0(MESSAGE_STRING_LENGTH_LESS_THAN, this.value_0);
          break;
        case 'lte':
          tmp$ = this.fillMessage_0(MESSAGE_STRING_LENGTH_LESS_THAN_OR_EQUAL, this.value_0);
          break;
        default:throw new IllegalOperatorException();
      }
      return tmp$;
    }
  });
  StringLength.prototype.passes_yuqcw7$ = function (attribute, value) {
    var tmp$;
    var length = null === value ? 0 : value.length;
    switch (this.operator_0) {
      case 'eq':
        tmp$ = length === this.value_0;
        break;
      case 'gt':
        tmp$ = length > this.value_0;
        break;
      case 'gte':
        tmp$ = length >= this.value_0;
        break;
      case 'lt':
        tmp$ = length < this.value_0;
        break;
      case 'lte':
        tmp$ = length <= this.value_0;
        break;
      default:throw new IllegalOperatorException();
    }
    return tmp$;
  };
  StringLength.prototype.fillMessage_0 = function (message, value) {
    return replace(message, '{length}', value.toString());
  };
  StringLength.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'StringLength',
    interfaces: [Rule]
  };
  function hello() {
    return 'Hello from JS';
  }
  function Sample() {
  }
  Sample.prototype.checkMe = function () {
    return 12;
  };
  Sample.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'Sample',
    interfaces: []
  };
  function Platform() {
    Platform_instance = this;
    this.name = 'JS';
  }
  Platform.$metadata$ = {
    kind: Kind_OBJECT,
    simpleName: 'Platform',
    interfaces: []
  };
  var Platform_instance = null;
  function Platform_getInstance() {
    if (Platform_instance === null) {
      new Platform();
    }
    return Platform_instance;
  }
  var package$net = _.net || (_.net = {});
  var package$ntworld = package$net.ntworld || (package$net.ntworld = {});
  var package$kotlin = package$ntworld.kotlin || (package$ntworld.kotlin = {});
  var package$validator = package$kotlin.validator || (package$kotlin.validator = {});
  package$validator.MessageBag = MessageBag;
  package$validator.Rule = Rule;
  package$validator.RuleBuilder = RuleBuilder;
  package$validator.Validatable = Validatable;
  package$validator.ValidationResult = ValidationResult;
  package$validator.Validator = Validator;
  package$validator.ValidatorBuilder = ValidatorBuilder;
  package$validator.ValidatorBuilderDsl = ValidatorBuilderDsl;
  package$validator.RuleDsl = RuleDsl;
  package$validator.RuleBuilderDsl = RuleBuilderDsl;
  package$validator.and_d5r4ay$ = and;
  package$validator.plus_d5r4ay$ = plus;
  package$validator.validatedBy_auvami$ = validatedBy;
  package$validator.validate_wymoy1$ = validate;
  package$validator.assert_auvami$ = assert;
  package$validator.assert_w0k1vm$ = assert_0;
  var package$rule = package$validator.rule || (package$validator.rule = {});
  package$rule.ArraySize = ArraySize;
  $$importsForInline$$['kotlin-validator'] = _;
  Object.defineProperty(package$validator, 'MESSAGE_OPTIONAL_8be2vx$', {
    get: function () {
      return MESSAGE_OPTIONAL;
    }
  });
  Object.defineProperty(package$validator, 'MESSAGE_REQUIRED_8be2vx$', {
    get: function () {
      return MESSAGE_REQUIRED;
    }
  });
  Object.defineProperty(package$validator, 'MESSAGE_NOT_NULL_8be2vx$', {
    get: function () {
      return MESSAGE_NOT_NULL;
    }
  });
  Object.defineProperty(package$validator, 'MESSAGE_NESTED_VALIDATOR_8be2vx$', {
    get: function () {
      return MESSAGE_NESTED_VALIDATOR;
    }
  });
  Object.defineProperty(package$validator, 'MESSAGE_PASS_8be2vx$', {
    get: function () {
      return MESSAGE_PASS;
    }
  });
  Object.defineProperty(package$validator, 'MESSAGE_REGEX_8be2vx$', {
    get: function () {
      return MESSAGE_REGEX;
    }
  });
  Object.defineProperty(package$validator, 'MESSAGE_EACH_8be2vx$', {
    get: function () {
      return MESSAGE_EACH;
    }
  });
  Object.defineProperty(package$validator, 'MESSAGE_NOT_EMPTY_STRING_8be2vx$', {
    get: function () {
      return MESSAGE_NOT_EMPTY_STRING;
    }
  });
  Object.defineProperty(package$validator, 'MESSAGE_NUMBER_EQUAL_8be2vx$', {
    get: function () {
      return MESSAGE_NUMBER_EQUAL;
    }
  });
  Object.defineProperty(package$validator, 'MESSAGE_NUMBER_GREATER_THAN_8be2vx$', {
    get: function () {
      return MESSAGE_NUMBER_GREATER_THAN;
    }
  });
  Object.defineProperty(package$validator, 'MESSAGE_NUMBER_GREATER_THAN_OR_EQUAL_8be2vx$', {
    get: function () {
      return MESSAGE_NUMBER_GREATER_THAN_OR_EQUAL;
    }
  });
  Object.defineProperty(package$validator, 'MESSAGE_NUMBER_LESS_THAN_8be2vx$', {
    get: function () {
      return MESSAGE_NUMBER_LESS_THAN;
    }
  });
  Object.defineProperty(package$validator, 'MESSAGE_NUMBER_LESS_THAN_OR_EQUAL_8be2vx$', {
    get: function () {
      return MESSAGE_NUMBER_LESS_THAN_OR_EQUAL;
    }
  });
  Object.defineProperty(package$validator, 'MESSAGE_STRING_LENGTH_EQUAL_8be2vx$', {
    get: function () {
      return MESSAGE_STRING_LENGTH_EQUAL;
    }
  });
  Object.defineProperty(package$validator, 'MESSAGE_STRING_LENGTH_GREATER_THAN_8be2vx$', {
    get: function () {
      return MESSAGE_STRING_LENGTH_GREATER_THAN;
    }
  });
  Object.defineProperty(package$validator, 'MESSAGE_STRING_LENGTH_GREATER_THAN_OR_EQUAL_8be2vx$', {
    get: function () {
      return MESSAGE_STRING_LENGTH_GREATER_THAN_OR_EQUAL;
    }
  });
  Object.defineProperty(package$validator, 'MESSAGE_STRING_LENGTH_LESS_THAN_8be2vx$', {
    get: function () {
      return MESSAGE_STRING_LENGTH_LESS_THAN;
    }
  });
  Object.defineProperty(package$validator, 'MESSAGE_STRING_LENGTH_LESS_THAN_OR_EQUAL_8be2vx$', {
    get: function () {
      return MESSAGE_STRING_LENGTH_LESS_THAN_OR_EQUAL;
    }
  });
  Object.defineProperty(package$validator, 'MESSAGE_ARRAY_SIZE_EQUAL_8be2vx$', {
    get: function () {
      return MESSAGE_ARRAY_SIZE_EQUAL;
    }
  });
  Object.defineProperty(package$validator, 'MESSAGE_ARRAY_SIZE_GREATER_THAN_8be2vx$', {
    get: function () {
      return MESSAGE_ARRAY_SIZE_GREATER_THAN;
    }
  });
  Object.defineProperty(package$validator, 'MESSAGE_ARRAY_SIZE_GREATER_THAN_OR_EQUAL_8be2vx$', {
    get: function () {
      return MESSAGE_ARRAY_SIZE_GREATER_THAN_OR_EQUAL;
    }
  });
  Object.defineProperty(package$validator, 'MESSAGE_ARRAY_SIZE_LESS_THAN_8be2vx$', {
    get: function () {
      return MESSAGE_ARRAY_SIZE_LESS_THAN;
    }
  });
  Object.defineProperty(package$validator, 'MESSAGE_ARRAY_SIZE_LESS_THAN_OR_EQUAL_8be2vx$', {
    get: function () {
      return MESSAGE_ARRAY_SIZE_LESS_THAN_OR_EQUAL;
    }
  });
  Object.defineProperty(package$validator, 'OPERATOR_EQUAL', {
    get: function () {
      return OPERATOR_EQUAL;
    }
  });
  Object.defineProperty(package$validator, 'OPERATOR_GREATER_THAN', {
    get: function () {
      return OPERATOR_GREATER_THAN;
    }
  });
  Object.defineProperty(package$validator, 'OPERATOR_GREATER_THAN_OR_EQUAL', {
    get: function () {
      return OPERATOR_GREATER_THAN_OR_EQUAL;
    }
  });
  Object.defineProperty(package$validator, 'OPERATOR_LESS_THAN', {
    get: function () {
      return OPERATOR_LESS_THAN;
    }
  });
  Object.defineProperty(package$validator, 'OPERATOR_LESS_THAN_OR_EQUAL', {
    get: function () {
      return OPERATOR_LESS_THAN_OR_EQUAL;
    }
  });
  package$validator.validator_z9bomw$ = validator;
  package$validator.validate_g4qf0u$ = validate_0;
  package$validator.assertValid_g4qf0u$ = assertValid;
  var package$exception = package$validator.exception || (package$validator.exception = {});
  package$exception.IllegalOperatorException = IllegalOperatorException;
  package$exception.ValidationException = ValidationException;
  var package$internal = package$validator.internal || (package$validator.internal = {});
  package$internal.MessageBagImpl = MessageBagImpl;
  package$internal.RuleBuilderImpl = RuleBuilderImpl;
  package$internal.RuleCollectionImpl = RuleCollectionImpl;
  Object.defineProperty(RuleExecutor, 'Companion', {
    get: RuleExecutor$Companion_getInstance
  });
  package$internal.RuleExecutor = RuleExecutor;
  Object.defineProperty(package$internal, 'RuleFactory', {
    get: RuleFactory_getInstance
  });
  package$internal.ValidationResultImpl = ValidationResultImpl;
  package$internal.ValidatorBuilderImpl = ValidatorBuilderImpl;
  package$internal.ValidatorImpl = ValidatorImpl;
  package$internal.ValidatorItem = ValidatorItem;
  Object.defineProperty(ArraySize, 'Companion', {
    get: ArraySize$Companion_getInstance
  });
  package$rule.Each = Each;
  package$rule.NotEmptyString = NotEmptyString;
  package$rule.NotNull = NotNull;
  package$rule.NumberComparison = NumberComparison;
  package$rule.Optional = Optional;
  package$rule.Pass = Pass;
  package$rule.PassRegex = PassRegex;
  package$rule.Required = Required;
  package$rule.StringLength = StringLength;
  var package$sample = _.sample || (_.sample = {});
  package$sample.hello = hello;
  package$sample.Sample = Sample;
  Object.defineProperty(package$sample, 'Platform', {
    get: Platform_getInstance
  });
  RuleBuilderImpl.prototype.otherwise_61zpoe$ = RuleBuilder.prototype.otherwise_61zpoe$;
  RuleBuilderImpl.prototype.invoke_gpb7pm$ = RuleBuilder.prototype.invoke_gpb7pm$;
  RuleBuilderImpl.prototype.invoke_ol6fgm$ = RuleBuilder.prototype.invoke_ol6fgm$;
  RuleBuilderImpl.prototype.required_43xxzu$ = RuleBuilder.prototype.required_43xxzu$;
  RuleBuilderImpl.prototype.required_gpb7pm$ = RuleBuilder.prototype.required_gpb7pm$;
  RuleBuilderImpl.prototype.required_tikisq$ = RuleBuilder.prototype.required_tikisq$;
  RuleBuilderImpl.prototype.required_ol6fgm$ = RuleBuilder.prototype.required_ol6fgm$;
  Object.defineProperty(ValidatorBuilderImpl.prototype, 'exists', Object.getOwnPropertyDescriptor(ValidatorBuilder.prototype, 'exists'));
  Object.defineProperty(ValidatorBuilderImpl.prototype, 'notEmptyString', Object.getOwnPropertyDescriptor(ValidatorBuilder.prototype, 'notEmptyString'));
  Object.defineProperty(ValidatorBuilderImpl.prototype, 'notNull', Object.getOwnPropertyDescriptor(ValidatorBuilder.prototype, 'notNull'));
  Object.defineProperty(ValidatorBuilderImpl.prototype, 'required', Object.getOwnPropertyDescriptor(ValidatorBuilder.prototype, 'required'));
  ValidatorBuilderImpl.prototype.each_yx6dx6$ = ValidatorBuilder.prototype.each_yx6dx6$;
  ValidatorBuilderImpl.prototype.each_ssq3xn$ = ValidatorBuilder.prototype.each_ssq3xn$;
  ValidatorBuilderImpl.prototype.each_65y4br$ = ValidatorBuilder.prototype.each_65y4br$;
  ValidatorBuilderImpl.prototype.eq_atzj8u$ = ValidatorBuilder.prototype.eq_atzj8u$;
  ValidatorBuilderImpl.prototype.equal_atzj8u$ = ValidatorBuilder.prototype.equal_atzj8u$;
  ValidatorBuilderImpl.prototype.exactLength_za3lpa$ = ValidatorBuilder.prototype.exactLength_za3lpa$;
  ValidatorBuilderImpl.prototype.greaterThan_atzj8u$ = ValidatorBuilder.prototype.greaterThan_atzj8u$;
  ValidatorBuilderImpl.prototype.greaterThanOrEqual_atzj8u$ = ValidatorBuilder.prototype.greaterThanOrEqual_atzj8u$;
  ValidatorBuilderImpl.prototype.gt_atzj8u$ = ValidatorBuilder.prototype.gt_atzj8u$;
  ValidatorBuilderImpl.prototype.gte_atzj8u$ = ValidatorBuilder.prototype.gte_atzj8u$;
  ValidatorBuilderImpl.prototype.lessThan_atzj8u$ = ValidatorBuilder.prototype.lessThan_atzj8u$;
  ValidatorBuilderImpl.prototype.lessThanOrEqual_atzj8u$ = ValidatorBuilder.prototype.lessThanOrEqual_atzj8u$;
  ValidatorBuilderImpl.prototype.lt_atzj8u$ = ValidatorBuilder.prototype.lt_atzj8u$;
  ValidatorBuilderImpl.prototype.lte_atzj8u$ = ValidatorBuilder.prototype.lte_atzj8u$;
  ValidatorBuilderImpl.prototype.matches_nz2z7i$ = ValidatorBuilder.prototype.matches_nz2z7i$;
  ValidatorBuilderImpl.prototype.matches_9j12k3$ = ValidatorBuilder.prototype.matches_9j12k3$;
  ValidatorBuilderImpl.prototype.matches_viu7q6$ = ValidatorBuilder.prototype.matches_viu7q6$;
  ValidatorBuilderImpl.prototype.maxLength_za3lpa$ = ValidatorBuilder.prototype.maxLength_za3lpa$;
  ValidatorBuilderImpl.prototype.minLength_za3lpa$ = ValidatorBuilder.prototype.minLength_za3lpa$;
  ValidatorBuilderImpl.prototype.pass_14urrv$ = ValidatorBuilder.prototype.pass_14urrv$;
  ValidatorBuilderImpl.prototype.passRegex_nz2z7i$ = ValidatorBuilder.prototype.passRegex_nz2z7i$;
  ValidatorBuilderImpl.prototype.passRegex_9j12k3$ = ValidatorBuilder.prototype.passRegex_9j12k3$;
  ValidatorBuilderImpl.prototype.passRegex_viu7q6$ = ValidatorBuilder.prototype.passRegex_viu7q6$;
  ValidatorBuilderImpl.prototype.passes_14urrv$ = ValidatorBuilder.prototype.passes_14urrv$;
  ValidatorBuilderImpl.prototype.run_r82fwp$ = ValidatorBuilder.prototype.run_r82fwp$;
  ValidatorBuilderImpl.prototype.use_r82fwp$ = ValidatorBuilder.prototype.use_r82fwp$;
  ValidatorBuilderImpl.prototype.invoke_gpb7pm$ = ValidatorBuilder.prototype.invoke_gpb7pm$;
  ValidatorBuilderImpl.prototype.invoke_ol6fgm$ = ValidatorBuilder.prototype.invoke_ol6fgm$;
  ValidatorBuilderImpl.prototype.required_43xxzu$ = ValidatorBuilder.prototype.required_43xxzu$;
  ValidatorBuilderImpl.prototype.required_gpb7pm$ = ValidatorBuilder.prototype.required_gpb7pm$;
  ValidatorBuilderImpl.prototype.required_tikisq$ = ValidatorBuilder.prototype.required_tikisq$;
  ValidatorBuilderImpl.prototype.required_ol6fgm$ = ValidatorBuilder.prototype.required_ol6fgm$;
  ValidatorImpl.prototype.plus_8cw8f8$ = Validator.prototype.plus_8cw8f8$;
  MESSAGE_OPTIONAL = '';
  MESSAGE_REQUIRED = ':attribute is required.';
  MESSAGE_NOT_NULL = ':attribute must be exist.';
  MESSAGE_NESTED_VALIDATOR = '';
  MESSAGE_PASS = ':attribute is invalid.';
  MESSAGE_REGEX = ':attribute is invalid.';
  MESSAGE_EACH = ':attribute is invalid.';
  MESSAGE_NOT_EMPTY_STRING = ':attribute is required and not empty.';
  MESSAGE_NUMBER_EQUAL = ':attribute must be equal {value}.';
  MESSAGE_NUMBER_GREATER_THAN = ':attribute must be greater than {value}.';
  MESSAGE_NUMBER_GREATER_THAN_OR_EQUAL = ':attribute must be greater than or equal {value}.';
  MESSAGE_NUMBER_LESS_THAN = ':attribute must be less than {value}.';
  MESSAGE_NUMBER_LESS_THAN_OR_EQUAL = ':attribute must be less than or equal {value}.';
  MESSAGE_STRING_LENGTH_EQUAL = ':attribute must have length equal {length}.';
  MESSAGE_STRING_LENGTH_GREATER_THAN = ':attribute must have length greater than {length}.';
  MESSAGE_STRING_LENGTH_GREATER_THAN_OR_EQUAL = ':attribute must have length greater than or equal {length}.';
  MESSAGE_STRING_LENGTH_LESS_THAN = ':attribute must have length less than {length}.';
  MESSAGE_STRING_LENGTH_LESS_THAN_OR_EQUAL = ':attribute must have length less than or equal {length}.';
  MESSAGE_ARRAY_SIZE_EQUAL = ':attribute must have size equal {length}.';
  MESSAGE_ARRAY_SIZE_GREATER_THAN = ':attribute must have size greater than {length}.';
  MESSAGE_ARRAY_SIZE_GREATER_THAN_OR_EQUAL = ':attribute must have size greater than or equal {length}.';
  MESSAGE_ARRAY_SIZE_LESS_THAN = ':attribute must have size less than {length}.';
  MESSAGE_ARRAY_SIZE_LESS_THAN_OR_EQUAL = ':attribute must have size less than or equal {length}.';
  OPERATOR_EQUAL = 'eq';
  OPERATOR_GREATER_THAN = 'gt';
  OPERATOR_GREATER_THAN_OR_EQUAL = 'gte';
  OPERATOR_LESS_THAN = 'lt';
  OPERATOR_LESS_THAN_OR_EQUAL = 'lte';
  Kotlin.defineModule('kotlin-validator', _);
  return _;
}(typeof this['kotlin-validator'] === 'undefined' ? {} : this['kotlin-validator'], kotlin);
